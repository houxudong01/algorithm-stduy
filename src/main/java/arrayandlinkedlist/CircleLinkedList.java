package arrayandlinkedlist;

/**
 * 循环链表
 *
 * @author:hxd
 * @date:2019/11/2
 */
public class CircleLinkedList {
    private ListNode head;
    private ListNode tail;

    public CircleLinkedList() {
        head = tail = new ListNode(null);
        head.next = tail;
        tail.next = head;
    }

    class ListNode {
        Integer value;
        ListNode next;

        ListNode(Integer value) {
            this.value = value;
        }

        public void add(ListNode node) {
            if (this == tail) {
                this.next = node;
                node.next = head;
                tail = node;
            } else {
                this.next.add(node);
            }
        }

        public Boolean remove(int value) {
            ListNode current = head.next;
            ListNode previous = head;
            while (current != head) {
                ListNode next = current.next;
                if (current.value == value) {
                    previous.next = next;
                    return true;
                }
                previous = current;
                current = next;
            }
            return false;
        }
    }

    public void add(int value) {
        ListNode newNode = new ListNode(value);
        this.head.add(newNode);
    }

    public Boolean remove(int value) {
        return this.head.remove(value);
    }

}
