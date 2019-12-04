//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

// 题目编号：98
// https://leetcode-cn.com/problems/validate-binary-search-tree/
@SuppressWarnings("all")
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        TreeNode node = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(6);
        TreeNode node8 = new TreeNode(3);

        node.left = node2;
        node.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.right = node8;
        System.out.println(solution.isValidBST(node));

    }


//leetcode submit region begin(Prohibit modification and deletion)

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        // 注意：变量不要跟入递归栈中，不然出栈后值会被吞掉
        long pre = Long.MIN_VALUE;
        boolean flag = true;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            midOrder(root);
            return flag;
        }

        private void midOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            midOrder(root.left);
            if (root.val <= pre) {
                flag = false;
                return;
            }
            pre = root.val;
            midOrder(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}