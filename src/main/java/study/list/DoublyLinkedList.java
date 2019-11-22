package study.list;

/**
 * @author:hxd
 * @date:2019/11/3
 */
public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;

    public DoublyLinkedList() {
        this.head = this.tail = new ListNode(null);
    }

    class ListNode {
        Integer value;
        ListNode pre;
        ListNode next;

        ListNode(Integer value) {
            this.value = value;
        }

        public void add(ListNode node) {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }

        public void print() {
            System.out.print(this.value + "->");
            if (this == tail) {
                return;
            }
            this.next.print();
        }

        public Boolean remove(int value) {
            if (head == null) {
                return false;
            }

            ListNode current = this;
            while (current != null) {
                ListNode next = current.next;
                if (current.value == value) {
                    current.pre.next = next;
                    next.pre = current.pre;
                    return true;
                }
                current = next;
            }
            return false;
        }
    }

    public void add(int value) {
        this.head.add(new ListNode(value));
    }

    public void print() {
        this.head.next.print();
    }

    public Boolean remove(int value) {
        return this.head.next.remove(value);
    }

}
