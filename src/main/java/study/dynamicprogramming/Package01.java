package study.dynamicprogramming;

/**
 * 使用动态规划解决 0-1背包问题
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
    private int f() {
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
}
