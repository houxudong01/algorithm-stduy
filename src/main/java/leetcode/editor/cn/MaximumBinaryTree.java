//给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下： 
//
// 
// 二叉树的根是数组中的最大元素。 
// 左子树是通过数组中最大值左边部分构造出的最大二叉树。 
// 右子树是通过数组中最大值右边部分构造出的最大二叉树。 
// 
//
// 通过给定的数组构建最大二叉树，并且输出这个树的根节点。 
//
// 
//
// 示例 ： 
//
// 输入：[3,2,1,6,0,5]
//输出：返回下面这棵树的根节点：
//
//      6
//    /   \
//   3     5
//    \    / 
//     2  0   
//       \
//        1
// 
//
// 
//
// 提示： 
//
// 
// 给定的数组的大小在 [1, 1000] 之间。 
// 
// Related Topics 树


package leetcode.editor.cn;

// 题目编号：654
// https://leetcode-cn.com/problems/maximum-binary-tree/
@SuppressWarnings("all")
public class MaximumBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumBinaryTree().new Solution();
        int[] nums = new int[]{3,2,1,6,0,5};
        TreeNode treeNode = solution.constructMaximumBinaryTree(nums);
        System.out.println(treeNode);
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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return recur(0, nums.length, nums);
        }

        public TreeNode recur(int start, int end, int[] nums) {
            if (start < 0 || end > nums.length || start >= end) {
                return null;
            }
            int maxIndex = getMax(start, end, nums);

            TreeNode node = new TreeNode(nums[maxIndex]);
            node.left = recur(start, maxIndex, nums);
            node.right = recur(maxIndex + 1, end, nums);
            return node;
        }

        public int getMax(int start, int end, int[] nums) {
            int max = Integer.MIN_VALUE;
            int maxIndex = start;
            for (int i = start; i < end; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            return maxIndex;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}