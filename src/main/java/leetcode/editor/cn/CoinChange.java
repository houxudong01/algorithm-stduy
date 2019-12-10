//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划

package leetcode.editor.cn;

import java.util.Arrays;

// 题目编号：322
// https://leetcode-cn.com/problems/coin-change/
@SuppressWarnings("all")
public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        int[] coins = new int[]{186, 419, 83, 408};
        int amount = 6249;
        System.out.println(solution.coinChange(coins, amount));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);
            // dp[j] = value，表示凑成金额 j 需要 value 个硬币
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    // 当前的金额减去此硬币的面值是否大于等于 0
                    if (j - coins[i] >= 0) {
                        // 状态转移方程
                        // 当前的金额需要的硬币数 就等于 当前金额减去此硬币面值 剩下的金额 所需要的硬币数加1，再和当前需要的硬币数 取最小值
                        dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                    }
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}