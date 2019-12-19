//给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。 
//
// 示例 : 
//
// 
//输入:
//
//   1
//    \
//     3
//    /
//   2
//
//输出:
//1
//
//解释:
//最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 注意: 树中至少有2个节点。 
// Related Topics 树

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 题目编号：530
// https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
@SuppressWarnings("all")
public class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        node.right = node2;
        node2.left = node3;
        solution.getMinimumDifference(node);
    }


//leetcode submit region begin(Prohibit modification and deletion)

    //  Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        private int minVal = Integer.MAX_VALUE;
        private TreeNode preNode = null;

        public int getMinimumDifference(TreeNode root) {
            inOrder(root);
            return minVal;
        }

        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            if (preNode != null) {
                minVal = Math.min(minVal, root.val - preNode.val);
            }
            preNode = root;
            inOrder(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}