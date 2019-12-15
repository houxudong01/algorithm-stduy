//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;

// 题目编号：337
// https://leetcode-cn.com/problems/house-robber-iii/
@SuppressWarnings("all")
public class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
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

        /**
         * 思路：
         * 能盗取的最高金额等于 抢劫该节点 + 抢劫该节点的左孩子的左右子树 + 抢劫该节点的右孩子的左右子树 和
         * 抢劫该节点左子树与抢劫该节点右子树的和 的最大值
         *
         * @param root
         * @return
         */
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int val1 = root.val;
            if (root.left != null) {
                val1 += rob(root.left.left) + rob(root.left.right);
            }
            if (root.right != null) {
                val1 += rob(root.right.left) + rob(root.right.right);
            }
            int val2 = rob(root.left) + rob(root.right);
            return Math.max(val1, val2);
        }

        /**
         * 动态规划
         * 定义一个result[]数组
         * result[0] 表示不抢劫当前根节点可偷盗的最大值
         * result[1] 表示抢劫当前根节点可偷盗的最大值
         * <p>
         * 调用方式：
         * int[] result = recurse(root);
         * return Math.max(result[0], result[1]);
         *
         * @param root
         * @return
         */
        private int[] recurse(TreeNode root) {
            if (root == null) {
                return new int[2];
            }
            // 抢劫左子树，返回抢劫根节点（左子树根节点）与不抢劫根节点可偷盗的最大值
            int[] left = recurse(root.left);
            // 抢劫右子树，返回抢劫根节点（右子树根节点）与不抢劫根节点可偷盗的最大值
            int[] right = recurse(root.right);
            int[] result = new int[2];
            // 不抢劫当前根节点，左右子树可以随便抢，返回最大偷盗值
            result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            // 抢劫当前根节点，左右子树根节点不能抢
            result[1] = root.val + left[0] + right[0];
            return result;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}