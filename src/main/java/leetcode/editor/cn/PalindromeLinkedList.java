//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针

package leetcode.editor.cn;

// 题目编号：234
// https://leetcode-cn.com/problems/palindrome-linked-list/
@SuppressWarnings("all")
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(solution.isPalindrome(node1));
    }


//leetcode submit region begin(Prohibit modification and deletion)

    //  Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode fast = head;
            ListNode slow = head;

            ListNode sp = null;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                sp = slow;
                slow = slow.next;
            }

            ListNode head2 = null;
            if (fast.next == null) {
                if (sp != null) {
                    sp.next = null;
                }
                head2 = slow.next;
            } else if (fast.next.next == null) {
                head2 = slow.next;
            }
            head2 = reverse(head2);

            while (head != null && head2 != null) {
                if (head.val != head2.val) {
                    return false;
                }
                head = head.next;
                head2 = head2.next;
            }
            return true;
        }

        private ListNode reverse(ListNode head) {
            ListNode current = head;
            ListNode pre = null;
            while (current != null) {
                ListNode next = current.next;
                current.next = pre;
                pre = current;
                current = next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}