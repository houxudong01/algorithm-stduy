package study.hash;

/**
 * 实现一个 LRU 缓存淘汰算法
 *
 * @author:hxd
 * @date:2019/11/6
 */
public class MyLru<K, V> {
    /**
     * 用哈希表作缓存
     */
    private MyHashMap<K, V> cacheMap;
    /**
     * 首节点，只作为挂载点存在，无实际意义
     * head.next 是最久未被访问的节点
     */
    private Node head;
    /**
     * 最新被访问的节点
     */
    private Node tail;

    /**
     * 实际缓存数据节点个数
     */
    private int cacheSize;
    /**
     * 缓存最大容量，超出后需要淘汰最近最少使用的数据节点
     */
    private static final int MAX_CACHE_SIZE = 10;

    public MyLru() {
        cacheMap = new MyHashMap();
        head = tail = new Node(null, null);
    }

    /**
     * 增加元素
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        if (cacheMap.get(key) == null) {
            cacheMap.put(key, value);
            Node node = new Node(key, value);
            if (cacheSize >= MAX_CACHE_SIZE) {
                removeHead();
                --cacheSize;
            }
            addTail(node);
            cacheSize++;
        } else {
            Node node = findNode(key);
            node.value = value;
            unLink(node);
            addTail(node);
            cacheMap.put(key, value);
        }
    }

    /**
     * 访问元素
     *
     * @param key
     * @return
     */
    public V get(K key) {
        V v = cacheMap.get(key);
        Node node = findNode(key);
        unLink(node);
        addTail(node);
        return v;
    }

    /**
     * 移除元素
     *
     * @param key
     * @return
     */
    public V remove(K key) {
        V remove = cacheMap.remove(key);
        Node node = findNode(key);
        unLink(node);
        return remove;
    }

    /**
     * 将节点添加到链表尾部
     *
     * @param node
     */
    private void addTail(Node node) {
        tail.next = node;
        node.pre = tail;
        tail = node;
    }

    /**
     * 移除最久未被访问的节点
     */
    private void removeHead() {
        Node firstNode = head.next;
        head.next = firstNode.next;
        firstNode.next.pre = head;
        // help GC
        firstNode = null;
        firstNode = null;
    }

    /**
     * 将节点从链表中移除
     *
     * @param node
     */
    private void unLink(Node node) {
        if (node == tail) {
            return;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    /**
     * 从链表中找到等于key的节点
     *
     * @param key
     * @return
     */
    private Node findNode(K key) {
        Node current = head.next;
        while (current != null) {
            Node next = current.next;
            if (current.key == key || current.key.equals(key)) {
                break;
            }
            current = next;
        }
        return current;
    }

    /**
     * lru 链表节点
     */
    class Node {
        K key;
        V value;
        Node pre;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
