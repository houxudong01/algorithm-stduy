package stack;

/**
 * 使用链表实现一个栈
 *
 * @author:hxd
 * @date:2019/11/3
 */
public class MyLinkedStack {
    private Node head;
    private Node tail;

    public MyLinkedStack() {
        this.head = this.tail = new Node(null);
    }

    class Node {
        Integer value;
        Node next;

        Node(Integer value) {
            this.value = value;
        }

        public Boolean add(Node node) {
            if (this.next == null) {
                this.next = node;
                tail = node;
            } else {
                this.next.add(node);
            }
            return true;
        }

        public Integer removeTail() {
            if (tail == head) {
                return null;
            }
            Integer value = tail.value;

            Node current = head;
            Node previous = null;
            while (current != null) {
                Node next = current.next;
                if (current == tail) {
                    previous.next = next;
                    tail = previous;
                    return value;
                }
                previous = current;
                current = next;
            }
            return null;

        }
    }

    public Boolean push(int value) {
        Node node = new Node(value);
        return this.head.add(node);
    }

    public Integer pop() {
        return this.head.removeTail();
    }
}
