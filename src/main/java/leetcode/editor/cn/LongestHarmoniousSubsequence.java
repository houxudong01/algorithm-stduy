//和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。 
//
// 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,2,5,2,3,7]
//输出: 5
//原因: 最长的和谐数组是：[3,2,2,2,3].
// 
//
// 说明: 输入的数组长度最大不超过20,000. 
// Related Topics 哈希表

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 题目编号：594
// https://leetcode-cn.com/problems/longest-harmonious-subsequence/
@SuppressWarnings("all")
public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestHarmoniousSubsequence().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLHS(int[] nums) {
            // 记录数组中每个值出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int maxLength = 0;
            for (int num : nums) {
                if (map.containsKey(num + 1)) {
                    maxLength = Math.max(maxLength, map.get(num + 1) + map.get(num));
                }
            }
            return maxLength;
        }

        public int findLHS2(int[] nums) {
            Arrays.sort(nums);
            int maxLength = 0;
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                while (nums[j] - nums[i] > 1) {
                    i++;
                }
                if (nums[j] - nums[i] == 1) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}