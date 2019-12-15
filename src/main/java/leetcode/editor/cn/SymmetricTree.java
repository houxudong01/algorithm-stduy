//给定一个二叉树，检查它是否是镜像对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 说明: 
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。 
// Related Topics 树 深度优先搜索 广度优先搜索

package leetcode.editor.cn;

// 题目编号：101
// https://leetcode-cn.com/problems/symmetric-tree/
@SuppressWarnings("all")
public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            recurse(root.left);
            return check(root.left, root.right);
        }

        // 翻转子树
        private TreeNode recurse(TreeNode root) {
            if (root == null) {
                return root;
            }
            TreeNode left = root.left;
            root.left = recurse(root.right);
            root.right = recurse(left);
            return root;
        }

        // 检查两个子树是否完全一致
        private boolean check(TreeNode r1, TreeNode r2) {
            if (r1 == null && r2 == null) {
                return true;
            }
            return (r1 != null && r2 != null && r1.val == r2.val) && check(r1.left, r2.left) && check(r1.right, r2.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}