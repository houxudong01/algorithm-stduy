//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划


package leetcode.editor.cn;

// 题目编号：416
// https://leetcode-cn.com/problems/partition-equal-subset-sum/
@SuppressWarnings("all")
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            //动态规划，背包问题，从nums中选择一部分数字组合，填满容量为sum/2的背包
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            // 两个相等的数的和一定是偶数
            if (sum % 2 != 0) {
                return false;
            }
            int capacity = sum / 2;
            // dp[i][j] 表示是否将前 m 个数字放到容量为 j 的背包中能否装满
            boolean[][] dp = new boolean[nums.length][capacity + 1];
            // 初始化第一行
            if (nums[0] <= capacity) {
                dp[0][nums[0]] = true;
            }

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j <= capacity; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (nums[i] <= j) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    }
                }
            }
            return dp[nums.length - 1][capacity];
        }

        public boolean canPartition2(int[] nums) {
            //动态规划，背包问题，从nums中选择一部分数字组合，填满容量为sum/2的背包
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            // 两个相等的数的和一定是偶数
            if ((sum & 1) == 1) {
                return false;
            }
            int capacity = sum / 2;

            boolean[] dp = new boolean[capacity + 1];
            if (nums[0] <= capacity) {
                dp[nums[0]] = true;
            }
            for (int i = 1; i < nums.length; i++) {
                for (int j = capacity; j >= nums[i]; j--) {
                    if (dp[capacity]) {
                        return true;
                    }
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
            return dp[capacity];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}