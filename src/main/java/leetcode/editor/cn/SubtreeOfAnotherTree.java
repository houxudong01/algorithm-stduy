//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树

package leetcode.editor.cn;

// 题目编号：572
// https://leetcode-cn.com/problems/subtree-of-another-tree/
@SuppressWarnings("all")
public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();
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
        boolean flag = false;

        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null || t == null) {
                return true;
            }
            preOrder(s, t);
            return flag;
        }

        // 先序遍历，如果节点值相当就需要判断检查
        private TreeNode preOrder(TreeNode root, TreeNode t) {
            if (root == null) {
                return root;
            }
            if (root.val == root.val) {
                if (check(root, t)) {
                    flag = true;
                    return root;
                }
            }
            preOrder(root.left, t);
            preOrder(root.right, t);
            return root;
        }

        // 递归检查每个位置的节点是否相同
        private boolean check(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            }
            return (s != null && t != null && s.val == t.val) && check(s.left, t.left) && check(s.right, t.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}