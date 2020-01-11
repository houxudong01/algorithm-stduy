//给定一个二进制数组， 计算其中最大连续1的个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
// 
//
// 注意： 
//
// 
// 输入的数组只包含 0 和1。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.concurrent.locks.ReentrantLock;

// 题目编号：485
// https://leetcode-cn.com/problems/max-consecutive-ones/
@SuppressWarnings("all")
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnes().new Solution();
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int last = -1;
            int pre = -1;
            for (int i = 0; i < nums.length; i++) {
                if (pre != 1 && nums[i] == 1) {
                    last = i;
                }
                if (pre == 1 && nums[i] == 0) {
                    max = Math.max(max, i - last);
                }
                if (i == nums.length - 1 && nums[i] == 1) {
                    max = Math.max(max, i - last + 1);
                }
                pre = nums[i];
            }
            return max;
        }

        public int findMaxConsecutiveOnes2(int[] nums) {
            int max = 0;
            int cur = 0;
            for (int num : nums) {
                cur = num == 0 ? 0 : cur + 1;
                max = Math.max(max, cur);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}