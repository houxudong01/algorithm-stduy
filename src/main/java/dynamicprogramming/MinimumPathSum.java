package dynamicprogramming;

/**
 * 求最小路径和
 * leetCode地址：https://leetcode-cn.com/problems/minimum-path-sum/
 * <p>
 * 动态规划的解题思路总结：
 * 1.状态转移表法
 * 2.状态转移方程法
 *
 * @author:hxd
 * @date:2019/11/20
 */
public class MinimumPathSum {

    private int minDist = Integer.MAX_VALUE;

    /**
     * 回溯算法解决
     *
     * @param i
     * @param j
     * @param dist
     * @param matrix
     * @param n
     * @return
     */
    public int minDistBt(int i, int j, int dist, int[][] matrix, int n) {
        if (i == n && j == n) {
            if (dist < minDist) {
                minDist = dist;
            }
            return minDist;
        }

        if (i < n) {
            minDistBt(i + 1, j, dist + matrix[i][j], matrix, n);
        }
        if (j < n) {
            minDistBt(i, j + 1, dist + matrix[i][j], matrix, n);
        }
        return minDist;
    }

    /**
     * 1.状态转移表法解决
     * <p>
     * 解题思路：
     * 回溯算法实现-》定义状态-》画递归树-》找重复子问题-》
     * 画状态转移表-》根据递推关系填表-》将填表过程翻译为代码
     *
     * @param grid 路径数组
     * @return
     */
    public int f(int[][] grid) {
        // grid 网格宽
        int m = grid.length;
        // grid 网格长
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


    private int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
    private int[][] mem = new int[matrix.length][matrix[0].length];

    /**
     * 2.状态转移方程法解决
     * <p>
     * 解题思路：
     * 找出最优子结构-》写状态转移方程-》将状态转移方程翻译为代码
     *
     * @param i
     * @param j
     * @return
     */
    public int minDist(int i, int j) {
        if (i == 0 && j == 0) {
            return matrix[0][0];
        }
        if (mem[i][j] > 0) {
            return mem[i][j];
        }

        int minLeft = Integer.MAX_VALUE;
        if (j - 1 >= 0) {
            minLeft = minDist(i, j - 1);
        }
        int minUp = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            minUp = minDist(i - 1, j);
        }

        int currentMinDist = matrix[i][j] + Math.min(minLeft, minUp);
        mem[i][j] = currentMinDist;
        return currentMinDist;
    }
}
