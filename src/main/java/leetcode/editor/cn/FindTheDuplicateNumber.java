//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出
//这个重复的数。 
//
// 示例 1: 
//
// 输入: [1,3,4,2,2]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [3,1,3,4,2]
//输出: 3
// 
//
// 说明： 
//
// 
// 不能更改原数组（假设数组是只读的）。 
// 只能使用额外的 O(1) 的空间。 
// 时间复杂度小于 O(n2) 。 
// 数组中只有一个重复的数字，但它可能不止重复出现一次。 
// 
// Related Topics 数组 双指针 二分查找


package leetcode.editor.cn;

// 题目编号：287
// https://leetcode-cn.com/problems/find-the-duplicate-number/
@SuppressWarnings("all")
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
        System.out.println(solution.findDuplicate3(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int l = i + 1;
                int h = nums.length - 1;
                while (l <= h) {
                    if (nums[l] == nums[i] || nums[h] == nums[i]) {
                        return nums[i];
                    }
                    l++;
                    h--;
                }
            }
            return -1;
        }

        public int findDuplicate2(int[] nums) {
            int slow = 0;
            int fast = 0;
            while (true) {
                fast = nums[nums[fast]];
                slow = nums[slow];
                if (slow == fast) {
                    fast = 0;
                    while (nums[slow] != nums[fast]) {
                        fast = nums[fast];
                        slow = nums[slow];
                    }
                }
                return nums[slow];
            }
        }

        public int findDuplicate3(int[] nums) {
            int l = 1;
            int h = nums.length;
            while (l < h) {
                int mid = l + ((h - l) >> 1);
                int cnt = 0;
                for (int num : nums) {
                    if (num <= mid) {
                        cnt++;
                    }
                }
                if (cnt <= mid) {
                    l = mid + 1;
                } else {
                    h = mid;
                }
            }
            return h;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}