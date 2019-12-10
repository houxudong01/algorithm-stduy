//给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划

package leetcode.editor.cn;

// 题目编号：152
// https://leetcode-cn.com/problems/maximum-product-subarray/
@SuppressWarnings("all")
public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        int[] nums = new int[]{2, 3, -2, 4};
        System.out.println(solution.maxProduct(nums));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE;
            int iMax = 1;
            int iMin = 1;

            for (int i = 0; i < nums.length; i++) {
                // 如果是负数，计算乘积后大小就反过来了，所以需要事先交换
                if (nums[i] < 0) {
                    int tmp = iMax;
                    iMax = iMin;
                    iMin = tmp;
                }
                // 当前最大值
                iMax = Math.max(iMax * nums[i], nums[i]);
                // 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin
                iMin = Math.min(iMin * nums[i], nums[i]);
                max = Math.max(max, iMax);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}