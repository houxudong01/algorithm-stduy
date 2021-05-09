package study.dynamicprogramming;

import java.util.Arrays;

/**
 * 有一个数字序列包含 n 个不同的数字，求出这个序列中的最长递增子序列长度
 *
 * @author:hxd
 * @date:2019/11/23
 */
public class LongestIncreaseSubSequence {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(lis(nums));
        System.out.println(findNumberOfLIS(nums));
    }

    /**
     * 有一个数字序列包含 n 个不同的数字，求出这个序列中的最长递增子序列长度
     *
     * @param nums
     * @return
     */
    public static int lis(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // state[i]表示:nums数组中以nums[i]结尾的最长递增子序列长度
        int[] state = new int[nums.length];
        //  初始化 state[i]
        Arrays.fill(state, 1);

        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    state[i] = Math.max(state[i], state[j] + 1);
                    maxLength = Math.max(state[i], maxLength);
                }
            }
        }

        return maxLength;
    }

    /**
     * 求最长递增子序列的个数
     *
     * @param nums
     * @return
     */
    public static int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // state[i]表示:nums数组中以nums[i]结尾的最长递增子序列长度
        int[] state = new int[nums.length];

        // 记录最长递增子序列的组合数
        int[] combination = new int[nums.length];

        //  初始化 state[i] 和 combination[i]
        Arrays.fill(state, 1);
        Arrays.fill(combination, 1);

        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 如果+1后长度大于当前 LIS，则组合数不变
                    if (state[j] + 1 > state[i]) {
                        state[i] = state[j] + 1;
                        combination[i] = combination[j];
                    }
                    // 如果+1后长度等于当前 LIS，则说明找到了新组合
                    else if (state[j] + 1 == state[i]) {
                        combination[i] += combination[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, state[i]);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (state[i] == maxLength) {
                res += combination[i];
            }
        }
        return res;
    }
}
