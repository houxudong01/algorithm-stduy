package study.dynamicprogramming;

/**
 * 使用动态规划解决 0-1背包问题
 * 可以参考：https://blog.csdn.net/chanmufeng/article/details/82955730
 *
 * @author:hxd
 * @date:2019/11/19
 */
public class Package01 {
    /**
     * 每个物品的重量
     */
    private int[] weight = new int[]{2, 2, 4, 6, 3};
    /**
     * 物品个数
     */
    private int n = 5;
    /**
     * 背包可以承受的重量
     */
    private int w = 9;

    /**
     * 计算让背包中物品总重量最大的放物品方式
     */
    private int f1() {
        // 存放每个物品的放法状态，放入背包或者不放入背包，默认值为 false
        boolean[][] states = new boolean[n][w + 1];
        // 初始化第一个物品的放法
        states[0][0] = true;
        if (weight[0] < w) {
            states[0][weight[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            // 第 i 个物品不放入背包
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j]) {
                    states[i][j] = true;
                }
            }
            // 第 i 个物品放入背包
            for (int j = 0; j + weight[i] <= w; j++) {
                if (states[i - 1][j]) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        // 输出结果
        for (int i = w; i >= 0; i--) {
            if (states[n - 1][i]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 递归解决
     * 调用入口：f2(w, v, w.length - 1, C)
     *
     * @param w        物品的重量数组
     * @param v        物品的价值数组
     * @param index    当前待选择的物品索引
     * @param capacity 当前背包有效容量
     * @return
     */
    private int f2(int[] w, int[] v, int index, int capacity) {
        if (index < 0 || capacity <= 0) {
            return 0;
        }
        // 不放第index个物品的情况
        int res = f2(w, v, index - 1, capacity);
        if (w[index] <= capacity) {
            res = Math.max(res, v[index] + f2(w, v, index - 1, capacity - w[index]));
        }
        return res;
    }

    /**
     * 使用动态规划，二维数组
     *
     * @param w        物品的重量数组
     * @param v        物品的价值数组
     * @param capacity 当前背包有效容量
     * @return
     */
    private int f3(int[] w, int[] v, int capacity) {
        int size = w.length;
        if (size == 0) {
            return 0;
        }
        // dp[i][j] 表示前 i 件物品的重量在不超过 j 的情况下所能存放的最大价值
        int[][] dp = new int[size][capacity + 1];

        // 初始化第一行，仅考虑容量为 capacity 的背包放第 0 个物品的情况
        for (int i = 0; i <= capacity; i++) {
            dp[0][i] = w[0] <= i ? v[0] : 0;
        }
        // 填充其他行列
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        }
        return dp[size - 1][capacity];
    }

    /**
     * 动态规划，一维数组
     *
     * @param w        物品的重量数组
     * @param v        物品的价值数组
     * @param capacity 当前背包有效容量
     * @return
     */
    private int f4(int[] w, int[] v, int capacity) {
        int size = w.length;
        if (size == 0) {
            return 0;
        }
        int[] dp = new int[capacity + 1];
        // 初始化，仅考虑容量为 capacity 的背包放第 0 个物品的情况
        for (int i = 0; i <= capacity; i++) {
            dp[i] = w[0] <= i ? v[0] : 0;
        }
        // 填充其他行列
        for (int i = 1; i < size; i++) {
            for (int j = capacity; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
        }
        return dp[capacity];
    }
}
