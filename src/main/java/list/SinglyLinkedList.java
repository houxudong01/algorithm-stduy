package list;

/**
 * 单向链表实现
 *
 * @author:hxd
 * @date:2019/11/2
 */
public class SinglyLinkedList {
    private ListNode rootNode;

    public SinglyLinkedList() {
        rootNode = new ListNode(null);
    }

    public class ListNode {
        private Integer value;
        private ListNode next;

        public ListNode(Integer value) {
            this.value = value;
        }

        private ListNode add(ListNode listNode) {
            if (this.next == null) {
                this.next = listNode;
            } else {
                this.next.add(listNode);
            }
            return listNode;
        }

        private Boolean remove(int value) {
            ListNode previous = rootNode;
            ListNode current = this;

            while (current != null) {
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

        private void print() {
            System.out.print(this.value + "->");
            if (this.next == null) {
                System.out.println();
            } else {
                this.next.print();
            }
        }
    }

    /**
     * 添加数据到链表
     *
     * @param value
     */
    public ListNode add(int value) {
        ListNode listNode = new ListNode(value);
        return this.rootNode.add(listNode);
    }

    /**
     * 移除等于指定值的节点
     *
     * @param value
     * @return
     */
    public Boolean remove(int value) {
        return this.rootNode.next.remove(value);
    }

    /**
     * 打印链表
     */
    public void print() {
        this.rootNode.next.print();
    }

    /**
     * 反转链表（前驱变后继）
     *
     * @param head
     */
    public void reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
    }

    /**
     * 寻找链表中间节点
     *
     * @param head
     * @return
     */
    public ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // 如果链表包含的节点个数是偶数，那么会存在两个中间节点，当前实现会返回第二个中间节点
        // 如果想返回第一个中间中间节点，那么下面的while条件替换为（fast.next != null && fast.next.next != null）
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 删除倒数第 n 个节点
     *
     * @param head
     * @param n
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        int i = 1;
        while (fast != null && i < n) {
            fast = fast.next;
            i++;
        }

        if (fast == null) {
            return head;
        }

        ListNode slow = head;
        ListNode previous = null;
        while (fast.next != null) {
            fast = fast.next;
            previous = slow;
            slow = slow.next;
        }

        if (previous == null) {
            return head.next;
        } else {
            previous.next = previous.next.next;
        }
        return head;
    }

    /**
     * 合并两个有序链表为一个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode solider = new ListNode(null);
        ListNode p = solider;

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }

        if (l2 != null) {
            p.next = l2;
        }
        return solider.next;
    }
}
