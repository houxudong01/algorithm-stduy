//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

package leetcode.editor.cn;

import javafx.scene.control.Skin;

// 题目编号：24
// https://leetcode-cn.com/problems/swap-nodes-in-pairs/
@SuppressWarnings("all")
public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode solider = new ListNode(-1);
            solider.next = head;
            ListNode pre = solider;
            while (pre.next != null && pre.next.next != null) {
                ListNode l1 = pre.next;
                ListNode l2 = pre.next.next;
                ListNode next = l2.next;

                // 交换 l1 和 l2 节点
                l1.next = next;
                l2.next = l1;

                // 把交换前处于后面的节点放到前面来，挂到前驱后面
                pre.next = l2;
                // 前驱指针移动到 l1 节点
                pre = l1;
            }
            return solider.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}