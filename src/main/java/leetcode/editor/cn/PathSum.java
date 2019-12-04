//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;

// 题目编号：112
// https://leetcode-cn.com/problems/path-sum/
@SuppressWarnings("all")
public class PathSum {
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
        TreeNode node = new TreeNode(-2);
        TreeNode node2 = new TreeNode(-3);
//        TreeNode node3 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(0);
//        TreeNode node5 = new TreeNode(2);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(6);
//        TreeNode node8 = new TreeNode(3);

        node.right = node2;
//        node.right = node3;
//
//        node2.left = node4;
//        node2.right = node5;
//
//        node3.left = node6;
//        node3.right = node7;
//
//        node5.right = node8;
        System.out.println(solution.hasPathSum(node, -5));
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
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null && root.val == sum) {
                return true;
            }
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}