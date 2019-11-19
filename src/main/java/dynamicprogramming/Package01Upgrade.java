package dynamicprogramming;

/**
 * 0-1背包问题升级版
 * 在重量的基础上引入价值，对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，
 * 在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢？
 *
 * @author:hxd
 * @date:2019/11/19
 */
public class Package01Upgrade {
    /**
     * 每个物品的重量
     */
    private int[] weight = new int[]{2, 2, 4, 6, 3};
    /**
     * 每个物品的价值
     */
    private int[] value = new int[]{3, 4, 8, 9, 6};
    /**
     * 物品个数
     */
    private int n = 5;
    /**
     * 背包可以承受的重量
     */
    private int w = 9;

    public int f() {
        // 每个物品的状态，值为放入后的价值
        int[][] states = new int[n][w + 1];
        // 将状态表初始化为 -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] < w) {
            states[0][weight[0]] = value[0];
        }

        // 动态规划
        for (int i = 1; i < n; i++) {
            // 第 i 个物品不放入背包
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j] > 0) {
                    states[i][j] = states[i - 1][j];
                }
            }
            // 第 i 个物品放入背包
            for (int j = 0; j + weight[i] <= w; j++) {
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }

        // 找出最大值
        int maxValue = -1;
        for (int i = 0; i < w + 1; i++) {
            if (states[n - 1][i] > maxValue) {
                maxValue = states[n - 1][i];
            }
        }
        return maxValue;
    }
}
