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

import com.sun.corba.se.impl.oa.poa.AOMEntry;

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
            if (coins == null || coins.length == 0) {
                return 0;
            }
            Arrays.sort(coins);
            // dp[i] 表示容量为i的背包，存放金额i需要的硬币数
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    if (i - coin >= 0) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}