package study.dynamicprogramming;

/**
 * 有一个数字序列包含 n 个不同的数字，求出这个序列中的最长递增子序列长度
 *
 * @author:hxd
 * @date:2019/11/23
 */
public class LongestIncreaseSubSequence {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 9, 3, 6, 5, 1, 7, 4};
        System.out.println(lis(nums));
    }

    public static int lis(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        // state[i]表示:nums数组中以nums[i]结尾的最长递增子序列长度
        int[] state = new int[nums.length];
        //  初始化 state[i]
        for (int i = 0; i < state.length; i++) {
            state[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (state[j] + 1 > state[i]) {
                        state[i] = state[j] + 1;
                    }
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < state.length; i++) {
            if (state[i] > maxLength) {
                maxLength = state[i];
            }
        }
        return maxLength;
    }
}
