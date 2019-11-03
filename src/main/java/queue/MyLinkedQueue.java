package queue;

/**
 * 无界链表队列
 *
 * @author:hxd
 * @date:2019/11/3
 */
public class MyLinkedQueue {
    /**
     * 首节点不存实际数据，新入队的数据挂在到首节点后
     */
    private Node first;
    /**
     * 尾节点，优先出队列
     */
    private Node last;
    private int size;

    public MyLinkedQueue() {
        first = last = new Node(null);
    }

    public int size() {
        return size;
    }

    class Node {
        Integer value;
        Node next;

        Node(Integer value) {
            this.value = value;
        }
    }

    public void put(int value) {
        Node node = new Node(value);
        last.next = node;
        last = node;
        size++;
    }

    public Integer take() {
        if (first.next == null) {
            return null;
        }
        Node node = first.next;
        if (node == last) {
            last = first;
        }

        first.next = node.next;
        size--;
        return node.value;
    }
}
