//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组. 
//
// 示例 1: 
//
// 输入:
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出: [3, 14.5, 11]
//解释:
//第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
// 
//
// 注意： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 题目编号：637
// https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
@SuppressWarnings("all")
public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new AverageOfLevelsInBinaryTree().new Solution();
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
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            // 当前层节点个数
            int size = queue.size();
            // 当前层还剩下的节点个数
            int count = size;
            // 当前层节点的和
            double sum = 0;
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                sum += poll.val;

                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }

                // cout==0 时说明当前层遍历完成，需要计算当前层的平均值
                if (--count == 0) {
                    result.add(sum / size);
                    // 计算完成后重新给下一层的size、count和sum赋值
                    size = queue.size();
                    count = size;
                    sum = 0;
                }
            }
            return result;
        }

        public List<Double> averageOfLevels2(TreeNode root) {
            List<Double> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                double sum = 0;
                // 遍历当前层的全部节点
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    sum += poll.val;
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
                result.add(sum / size);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}