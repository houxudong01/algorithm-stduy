//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。 
//
// 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 1->3->5->2->4->NULL
// 
//
// 示例 2: 
//
// 输入: 2->1->3->5->6->4->7->NULL 
//输出: 2->3->6->7->1->5->4->NULL 
//
// 说明: 
//
// 
// 应当保持奇数节点和偶数节点的相对顺序。 
// 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。 
// 
// Related Topics 链表

package leetcode.editor.cn;

// 题目编号：328
// https://leetcode-cn.com/problems/odd-even-linked-list/
@SuppressWarnings("all")
public class OddEvenLinkedList {
    public static void main(String[] args) {
        Solution solution = new OddEvenLinkedList().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode listNode = solution.oddEvenList(node1);
        System.out.println(listNode);
    }


//leetcode submit region begin(Prohibit modification and deletion)

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            ListNode current = head;
            int index = 1;
            ListNode solider1 = new ListNode(-1);
            ListNode p1 = solider1;
            ListNode solider2 = new ListNode(-1);
            ListNode p2 = solider2;
            while (current != null) {
                if (index++ % 2 == 1) {
                    p1.next = current;
                    p1 = p1.next;
                } else {
                    p2.next = current;
                    p2 = p2.next;
                }
                current = current.next;
            }
            p2.next = null;
            p1.next = solider2.next;
            return solider1.next;
        }

        public ListNode oddEvenList2(ListNode head) {
            if (head == null) {
                return head;
            }
            // 指向奇数节点的指针
            ListNode odd = head;
            // 指向偶数节点的指针
            ListNode even = head.next;
            // 奇数节点的头节点
            ListNode evenHead = even;

            while (even != null && even.next != null) {
                // 挂在奇数节点到奇数链表上
                odd.next = odd.next.next;
                // 奇数指针后移
                odd = odd.next;

                // 挂载偶数节点到偶数链表上
                even.next = even.next.next;
                // 偶数指针后移
                even = even.next;
            }
            // 将偶数链表挂载到奇数指针尾节点上
            odd.next = evenHead;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}