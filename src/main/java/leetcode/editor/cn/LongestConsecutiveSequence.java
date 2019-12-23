//给定一个未排序的整数数组，找出最长连续序列的长度。 
//
// 要求算法的时间复杂度为 O(n)。 
//
// 示例: 
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。 
// Related Topics 并查集 数组

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

// 题目编号：128
// https://leetcode-cn.com/problems/longest-consecutive-sequence/
@SuppressWarnings("all")
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive2(nums));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int maxL = 0;
            for (int i = 0; i < nums.length; i++) {
                int l = 1;
                int j = 1;
                while (set.contains(nums[i] + j)) {
                    set.remove(nums[i] + j);
                    l++;
                    j++;
                }
                j = 1;
                while (set.contains(nums[i] - j)) {
                    set.remove(nums[j] - i);
                    l++;
                    j++;
                }
                maxL = Math.max(maxL, l);
            }
            return maxL;
        }

        public int longestConsecutive2(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int maxL = 0;
            for (int num : nums) {
                if (set.remove(num)) {
                    int cur = num;
                    int len = 1;
                    while (set.remove(cur - 1)) {
                        cur--;
                    }
                    len += (num - cur);
                    cur = num;
                    while (set.remove(cur + 1)) {
                        cur++;
                    }
                    len += (cur - num);
                    maxL = Math.max(maxL, len);
                }
            }
            return maxL;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}