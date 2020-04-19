//在计算机界中，我们总是追求用有限的资源获取最大的收益。 
//
// 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。 
//
// 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。 
//
// 注意: 
//
// 
// 给定 0 和 1 的数量都不会超过 100。 
// 给定字符串数组的长度不会超过 600。 
// 
//
// 示例 1: 
//
// 
//输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
//输出: 4
//
//解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
// 
//
// 示例 2: 
//
// 
//输入: Array = {"10", "0", "1"}, m = 1, n = 1
//输出: 2
//
//解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
// 
// Related Topics 动态规划


package leetcode.editor.cn;

// 题目编号：474
// https://leetcode-cn.com/problems/ones-and-zeroes/
@SuppressWarnings("all")
public class OnesAndZeroes {
    public static void main(String[] args) {
        Solution solution = new OnesAndZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            if (strs == null || strs.length == 0 || m <= 0 || n <= 0) {
                return 0;
            }
            // dp[i][j][k] 表示前i个字符串，在0的个数为j，1的个数为k的情况下 可获得的最大字符串个数
            int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
            for (int i = 1; i <= strs.length; i++) {
                int zeros = 0;
                int ones = 0;
                // 分表统计当前字符串中0和1的个数
                for (char c : strs[i - 1].toCharArray()) {
                    if (c == '0') {
                        zeros++;
                    } else {
                        ones++;
                    }
                }

                for (int j = 0; j <= m; j++) {
                    for (int k = 0; k <= n; k++) {
                        // 两个背包的容量都大于当前0和1的个数
                        if (j >= zeros && k >= ones) {
                            // 选择与不选择当前字符串的最大值，选择的话，0背包的容量要考察 j-当前字符串中包含的0的个数，1背包的容量要考察 k-当前字符串中包含1的个数
                            dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                        } else {
                            dp[i][j][k] = dp[i - 1][j][k];
                        }
                    }
                }
            }
            return dp[strs.length][m][n];
        }


        public int findMaxForm2(String[] strs, int m, int n) {
            if (strs == null || strs.length == 0 || m <= 0 || n <= 0) {
                return 0;
            }
            // dp[i][j] 表示 使用0的个数小于等于i 和 使用1的个数小于等于j 的情况下，能拼出的字符串的最大数量
            int[][] dp = new int[m + 1][n + 1];
            for (String str : strs) {
                int zeros = 0;
                int ones = 0;
                for (char c : str.toCharArray()) {
                    if (c == '0') {
                        zeros++;
                    } else {
                        ones++;
                    }
                }
                // i和j是两个背包的容量，当前背包的容量必须大于等于当前字符串当中的0和1的数量
                for (int i = m; i >= zeros; i--) {
                    for (int j = n; j >= ones; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}