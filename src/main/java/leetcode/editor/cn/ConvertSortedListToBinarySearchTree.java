//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表

package leetcode.editor.cn;

// 题目编号：109
// https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
@SuppressWarnings("all")
public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
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

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return new TreeNode(head.val);
            }
            ListNode midPre = findMidPre(head);
            ListNode midNode = midPre.next;
            // 将链表从中间截成两段
            midPre.next = null;

            TreeNode root = new TreeNode(midNode.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(midNode.next);
            return root;
        }

        private ListNode findMidPre(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            ListNode pre = null;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                pre = slow;
                slow = slow.next;
            }
            return pre == null ? head : pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}