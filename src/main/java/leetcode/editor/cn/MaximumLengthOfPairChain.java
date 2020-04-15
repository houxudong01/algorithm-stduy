//给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。 
//
// 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。 
//
// 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。 
//
// 示例 : 
//
// 
//输入: [[1,2], [2,3], [3,4]]
//输出: 2
//解释: 最长的数对链是 [1,2] -> [3,4]
// 
//
// 注意： 
//
// 
// 给出数对的个数在 [1, 1000] 范围内。 
// 
// Related Topics 动态规划


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

// 题目编号：646
// https://leetcode-cn.com/problems/maximum-length-of-pair-chain/
@SuppressWarnings("all")
public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfPairChain().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLongestChain(int[][] pairs) {
            if (pairs == null || pairs.length == 0) {
                return 0;
            }
            // 将数对按每一对的第一个数从小到大排序
            Arrays.sort(pairs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            // 以 i 处 数对 结尾的数对链
            int[] dp = new int[pairs.length];
            Arrays.fill(dp, 1);
            int max = 1;
            for (int i = 1; i < pairs.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (pairs[j][1] < pairs[i][0]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        max = Math.max(max, dp[i]);
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}