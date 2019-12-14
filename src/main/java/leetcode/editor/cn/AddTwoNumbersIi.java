//给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。 
//
// 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 进阶: 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 示例: 
//
// 
//输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出: 7 -> 8 -> 0 -> 7
// 
// Related Topics 链表

package leetcode.editor.cn;

import java.util.Stack;

// 题目编号：445
// https://leetcode-cn.com/problems/add-two-numbers-ii/
@SuppressWarnings("all")
public class AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);
        node5.next = node6;
        node6.next = node7;

        ListNode node = solution.addTwoNumbers(node1, node5);
        System.out.println(node);
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 存放 l1 的值
            Stack<Integer> stack1 = new Stack<>();
            // 存放 l2 的值
            Stack<Integer> stack2 = new Stack<>();

            while (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }

            while (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }

            // 是否有进位
            int carry = 0;
            ListNode head = new ListNode(-1);
            while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
                Integer pop1 = stack1.isEmpty() ? 0 : stack1.pop();
                Integer pop2 = stack2.isEmpty() ? 0 : stack2.pop();
                int sum = pop1 + pop2 + carry;
                ListNode node = new ListNode(sum % 10);
                node.next = head.next;
                head.next = node;
                carry = sum / 10;
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}