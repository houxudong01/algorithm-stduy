//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划

package leetcode.editor.cn;

// 题目编号：64
// https://leetcode-cn.com/problems/minimum-path-sum/
@SuppressWarnings("all")
public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] states = new int[m][n];

            // 初始化状态数组第一行
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += grid[0][j];
                states[0][j] = sum;
            }

            // 初始化状态数组第一列
            sum = 0;
            for (int i = 0; i < m; i++) {
                sum += grid[i][0];
                states[i][0] = sum;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    int up = states[i - 1][j];
                    int left = states[i][j - 1];
                    states[i][j] = Math.min(up, left) + grid[i][j];
                }
            }
            return states[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}