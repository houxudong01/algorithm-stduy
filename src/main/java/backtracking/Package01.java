package backtracking;

/**
 * 0-1背包问题
 * <p>
 * 问题描述：
 * 有一个背包，背包总的承载重量是 w kg。现在我们有 n 个物品，每个物品的重量不等，并且不可分割。
 * 我们现在期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 *
 * @author:hxd
 * @date:2019/11/16
 */
public class Package01 {
    /**
     * 包中物品总重量的最大值
     */
    private int maxW = Integer.MAX_VALUE;

    /**
     * @param i     考察到哪个物品了
     * @param cw    当前已经装进去的物品的重量总和
     * @param items 每个物品的重量
     * @param n     物品个数
     * @param w     背包可以承受的重量
     */
    public void f(int i, int cw, int[] items, int n, int w) {
        // cw==w表示装满了;i==n表示已经考察完所有的物品
        if (cw == w || i >= n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        // 第 i 个物品不放入背包
        f(i + 1, cw, items, n, w);

        // 第 i 个物品放入背包
        if (cw + items[i] <= w) {
            f(i + 1, cw + items[i], items, n, w);
        }
    }
}
