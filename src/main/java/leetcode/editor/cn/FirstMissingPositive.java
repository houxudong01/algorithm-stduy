//给定一个未排序的整数数组，找出其中没有出现的最小的正整数。 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 说明: 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

// 题目编号：41
// https://leetcode-cn.com/problems/first-missing-positive/
@SuppressWarnings("all")
public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        int[] nums = new int[]{3, 4, -1, 1};
        System.out.println(solution.firstMissingPositive(nums));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int[] temp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= nums.length && nums[i] > 0) {
                    temp[nums[i] - 1]++;
                }
            }
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == 0) {
                    return i + 1;
                }
            }
            return temp.length + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}