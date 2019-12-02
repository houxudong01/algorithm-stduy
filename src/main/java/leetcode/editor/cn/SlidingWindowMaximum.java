//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
// Related Topics 堆 Sliding Window

package leetcode.editor.cn;

import java.util.*;

// 题目编号：239
// https://leetcode-cn.com/problems/sliding-window-maximum/
@SuppressWarnings("all")
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] nums = new int[]{7, 2, 4};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, 2)));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || k == 0) {
                return nums;
            }
            // 保存结果
            int[] result = new int[nums.length - k + 1];
            // 保存当前窗口最大值的数组下标
            Deque<Integer> deque = new LinkedList<>();

            for (int i = 0; i < nums.length; i++) {
                // 保证数组下标位置数从大到小排列，如果前面的数小则弹出
                while (!deque.isEmpty() && nums[deque.peek()] <= nums[i]) {
                    deque.pollLast();
                }
                // 添加当前值的下标到队列中
                deque.addLast(i);
                // 初始化窗口
                if (deque.peek() <= i - k) {
                    deque.poll();
                }
                // 窗口长度达到 k 时，保存最大值到结果数组中
                if (i - k + 1 >= 0) {
                    result[i - k + 1] = nums[deque.peek()];
                }
            }
            return result;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}