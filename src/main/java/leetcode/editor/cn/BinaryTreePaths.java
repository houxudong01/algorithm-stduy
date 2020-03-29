//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 题目编号：257
// https://leetcode-cn.com/problems/binary-tree-paths/
@SuppressWarnings("all")
public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);

        root.left = node2;
        root.right = node3;

        node2.right = node4;

        System.out.println(solution.binaryTreePaths(root));
    }


//leetcode submit region begin(Prohibit modification and deletion)


    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            if (root.left == null && root.right == null) {
                res.add(root.val + "");
                return res;
            }
            StringBuilder sb = new StringBuilder();
            dfs(root, sb, res);
            return res;
        }

        private void dfs(TreeNode root, StringBuilder sb, List<String> res) {
            if (root == null) {
                return;
            }
            sb.append(root.val);
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left == null && right == null) {
                res.add(sb.toString());
                return;
            }
            if (left != null) {
                sb.append("->");
                dfs(left, sb, res);
                sb.delete(sb.length() - (left.val + "->").length(), sb.length());
            }
            if (right != null) {
                sb.append("->");
                dfs(right, sb, res);
                sb.delete(sb.length() - (right.val + "->").length(), sb.length());
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}