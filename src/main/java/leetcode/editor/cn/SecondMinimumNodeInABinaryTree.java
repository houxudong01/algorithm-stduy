//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
//
// 示例 1: 
//
// 
//输入: 
//    2
//   / \
//  2   5
//     / \
//    5   7
//
//输出: 5
//说明: 最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2: 
//
// 
//输入: 
//    2
//   / \
//  2   2
//
//输出: -1
//说明: 最小的值是 2, 但是不存在第二小的值。
// 
// Related Topics 树

package leetcode.editor.cn;

// 题目编号：671
// https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
@SuppressWarnings("all")
public class SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        Solution solution = new SecondMinimumNodeInABinaryTree().new Solution();
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
        public int findSecondMinimumValue(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) {
                return -1;
            }
            int leftVal = root.left.val;
            int rightVal = root.right.val;
            // 左孩子的值和当前根节点的值相等时，递归寻找第二小的
            if (root.val == leftVal) {
                leftVal = findSecondMinimumValue(root.left);
            }
            // 右孩子的值和当前根节点的值相等时，递归寻找第二小的
            if (root.val == rightVal) {
                rightVal = findSecondMinimumValue(root.right);
            }
            // 左右孩子的值都不和当前根节点相等时，可以直接确定第二小的
            if (leftVal != -1 && rightVal != -1) {
                return Math.min(leftVal, rightVal);
            }
            return leftVal != -1 ? leftVal : rightVal;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}