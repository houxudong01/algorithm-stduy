//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 示例 1: 
//
// 输入: nums: [1, 1, 1, 1, 1], S: 3
//输出: 5
//解释: 
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 注意: 
//
// 
// 数组非空，且长度不会超过20。 
// 初始的数组的和不会超过1000。 
// 保证返回的最终结果能被32位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划


package leetcode.editor.cn;

// 题目编号：494
// https://leetcode-cn.com/problems/target-sum/
@SuppressWarnings("all")
public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 494
         * 输入: nums: [1, 1, 1, 1, 1], S: 3
         * 输出: 5
         * 解释:
         * -1+1+1+1+1 = 3
         * +1-1+1+1+1 = 3
         * +1+1-1+1+1 = 3
         * +1+1+1-1+1 = 3
         * +1+1+1+1-1 = 3
         * <p>
         * sum(P) 前面符号为+的集合；sum(N) 前面符号为减号的集合
         * 所以题目可以转化为
         * sum(P) - sum(N) = target
         * => sum(P)+ sum(N) + sum(P) - sum(N) = target + sum(nums)
         * => 2 * sum(P) = target + sum(nums)
         * => sum(P) = (target + sum(nums)) / 2
         * 因此题目转化为01背包，也就是能组合成容量为sum(P)的方式有多少种
         */
        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum < S || ((sum + S) & 1) == 1) {
                return 0;
            }
            int capacity = (sum + S) / 2;
            // dp[i] 表示容量为 i 的背包有多少种放法
            int[] dp = new int[capacity + 1];
            // 容量为 0 时只有一种方式，就是不放
            dp[0] = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = capacity; j >= nums[i]; j--) {
                    // 1. dp[j] 的解法数为自身加上dp[j-num]的解法数
                    // 2. 这里为什么会如此，可以参考斐波那契数列
                    // 3. 这里我可以不放 num 进背包，解法数为 dp[j]
                    // 4. 将 num 放进背包，解法数为 dp[j-num] 所以此时的总解法数为 二者和
                    dp[j] += dp[j - nums[i]];
                }
            }
            return dp[capacity];
        }

        public int findTargetSumWays2(int[] nums, int S) {
            return dfs(nums, 0, S);
        }

        public int dfs(int[] nums, int index, int S) {
            if (index == nums.length) {
                return S == 0 ? 1 : 0;
            }
            return dfs(nums, index + 1, S + nums[index]) + dfs(nums, index + 1, S - nums[index]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}