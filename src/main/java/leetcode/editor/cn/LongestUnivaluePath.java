//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。 
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。 
//
// 示例 1: 
//
// 输入: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 示例 2: 
//
// 输入: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。 
// Related Topics 树 递归

package leetcode.editor.cn;

// 题目编号：687
// https://leetcode-cn.com/problems/longest-univalue-path/
@SuppressWarnings("all")
public class LongestUnivaluePath {
    public static void main(String[] args) {
        Solution solution = new LongestUnivaluePath().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)

    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        int maxPath = 0;

        public int longestUnivaluePath(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root);
            return maxPath;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 左子树上的同值路径长度
            int left = dfs(root.left);
            // 右子树上的同值路径长度
            int right = dfs(root.right);

            // root加左子树同值路径长度
            int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
            // root加右子树同值路径长度
            int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
            // 记录最长同值路径的长度
            maxPath = Math.max(maxPath, leftPath + rightPath);
            // 返回最长的一条同值树路径
            return Math.max(leftPath, rightPath);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}