//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树

package leetcode.editor.cn;

// 题目编号：404
// https://leetcode-cn.com/problems/sum-of-left-leaves/
@SuppressWarnings("all")
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)

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

        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int result = 0;
            if (root.left != null && root.left.left == null && root.left.right == null) {
                result += root.left.val;
            }
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + result;
        }

        int sum = 0;

        public int sumOfLeftLeaves2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            recurse(root, false);
            return sum;
        }

        private TreeNode recurse(TreeNode root, boolean left) {
            if (root == null) {
                return root;
            }
            recurse(root.left, true);
            if (left && root.left == null && root.right == null) {
                sum += root.val;
            }
            recurse(root.right, false);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}