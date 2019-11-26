//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 题目编号：15
// https://leetcode-cn.com/problems/3sum/
@SuppressWarnings("all")
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                // 跳过重复值
                if (i > 0 && (nums[i] == nums[i - 1])) {
                    continue;
                }

                // 左子针
                int j = i + 1;
                // 右子针
                int k = nums.length - 1;
                // nums[i]如果大于等于1，那么就可以终止了，因为后面的都比它大，三数之和不可能为0
                while (j < k && nums[i] < 1) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        // 跳过重复值
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        j++;
                        // 跳过重复值
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        k--;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        // 跳过重复值
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        j++;
                    } else {
                        // 跳过重复值
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        k--;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}