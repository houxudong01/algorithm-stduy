package hash;

/**
 * 实现一个基于链表法解决哈希冲突的散列表
 *
 * @author:hxd
 * @date:2019/11/5
 */
public class MyHashMap<K, V> {
    private Node<K, V>[] table;
    private int capacity;

    /**
     * 添加元素
     *
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {
        int h;
        int hash = key == null ? 0 : ((h = key.hashCode()) ^ (h >>> 16));
        if (table == null) {
            capacity = 16;
            table = new Node[capacity];
        }
        int putIndex = hash & (capacity - 1);
        Node<K, V> firstNode = table[putIndex];
        Node<K, V> newNode = new Node(key, value, hash, null);
        // 第一次添加，初始化数组
        if (firstNode == null) {
            table[putIndex] = newNode;
        } else {
            Node n;
            for (n = firstNode; n.next != null; n = n.next) {
                // 如果链表中存在key相同的节点，那么更新此节点的value
                if (n.key == key || n.key.equals(key)) {
                    return (V) n.setValue(value);
                }
            }
            n.next = newNode;
        }
        return value;
    }

    /**
     * 访问元素
     *
     * @param key
     * @return
     */
    public V get(K key) {
        if (table == null) {
            return null;
        }
        int h;
        int hash = key == null ? 0 : ((h = key.hashCode()) ^ (h >>> 16));
        int index = hash & (capacity - 1);
        Node<K, V> node = table[index];
        if (node == null) {
            return null;
        }
        // 如果首节点就是要找的元素，那么直接返回value
        if (node.key == key || node.key.equals(key)) {
            return node.getValue();
        } else {
            for (Node n = node; n != null; n = n.next) {
                if (n.key == key || n.key.equals(key)) {
                    return (V) n.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 删除元素
     *
     * @param key
     * @return
     */
    public V remove(K key) {
        if (table == null) {
            return null;
        }
        int h;
        int hash = key == null ? 0 : ((h = key.hashCode()) ^ (h >>> 16));
        int index = hash & (capacity - 1);
        Node<K, V> node = table[index];
        if (node == null) {
            return null;
        }
        if (node.key == key || node.key.equals(key)) {
            table[index] = node.next;
            return node.getValue();
        } else {
            Node current = node.next;
            Node previous = node;
            while (current != null) {
                Node next = current.next;
                if (current.key == key || current.key.equals(key)) {
                    previous.next = current.next;
                    return (V) current.getValue();
                }
                previous = current;
                current = next;
            }
        }
        return null;
    }

    class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, int hash, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }

        V getValue() {
            return this.value;
        }
    }
}
