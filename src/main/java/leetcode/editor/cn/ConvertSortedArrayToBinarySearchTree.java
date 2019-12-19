//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;

// 题目编号：108
// https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
@SuppressWarnings("all")
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
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
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null) {
                return null;
            }
            return buildTree(nums, 0, nums.length - 1);
        }

        private TreeNode buildTree(int[] nums, int i, int j) {
            if (i > j) {
                return null;
            }
            int m = i + ((j - i) >> 1);
            TreeNode root = new TreeNode(nums[m]);
            root.left = buildTree(nums, i, m - 1);
            root.right = buildTree(nums, m + 1, j);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}