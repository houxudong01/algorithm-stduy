//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

// 题目编号：167
// https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
@SuppressWarnings("all")
public class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 4, 9, 56, 90};
        System.out.println(solution.twoSum3(nums, 8));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                if (map.containsKey(target - numbers[i])) {
                    return new int[]{map.get(target - numbers[i]) + 1, i + 1};
                }
                map.put(numbers[i], i);
            }
            return null;
        }

        public int[] twoSum2(int[] numbers, int target) {
            int i = 0;
            int j = numbers.length - 1;
            while (i <= j) {
                int sum = numbers[i] + numbers[j];
                if (sum == target) {
                    return new int[]{i + 1, j + 1};
                }
                if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
            return null;
        }

        public int[] twoSum3(int[] numbers, int target) {
            for (int i = 0; i < numbers.length; i++) {
                int l = i;
                int h = numbers.length - 1;
                while (l <= h) {
                    int mid = l + ((h - l) >> 1);
                    if (mid == i) {
                        l = mid + 1;
                        continue;
                    }
                    if (target - numbers[i] == numbers[mid]) {
                        return new int[]{i + 1, mid + 1};
                    }
                    if (target - numbers[i] < numbers[mid]) {
                        h = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
            return null;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}