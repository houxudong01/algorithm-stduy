//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表

package leetcode.editor.cn;

import java.util.List;

// 题目编号：206
// https://leetcode-cn.com/problems/reverse-linked-list/
@SuppressWarnings("all")
public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = solution.reverseList(node1);
        System.out.println(listNode);
    }


//leetcode submit region begin(Prohibit modification and deletion)


    //    Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode solider = new ListNode(-1);
            recurse(head, null, solider);
            return solider.next;
        }

        private void recurse(ListNode node, ListNode previous, ListNode solider) {
            if (node != null) {
                recurse(node.next, node, solider);
                node.next = previous;
            } else {
                solider.next = previous;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}