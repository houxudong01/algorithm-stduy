//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。 
//
// 例如： 
//
// 
//输入: 二叉搜索树:
//              5
//            /   \
//           2     13
//
//输出: 转换为累加树:
//             18
//            /   \
//          20     13
// 
// Related Topics 树

package leetcode.editor.cn;

// 题目编号：538
// https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
@SuppressWarnings("all")
public class ConvertBstToGreaterTree {
    public static void main(String[] args) {
        Solution solution = new ConvertBstToGreaterTree().new Solution();
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
        int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return root;
            }
            convertBST(root.right);
            root.val += sum;
            sum = root.val;
            root.val = sum;
            convertBST(root.left);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}