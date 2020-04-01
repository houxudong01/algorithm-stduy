//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 题目编号：78
// https://leetcode-cn.com/problems/subsets/
@SuppressWarnings("all")
public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        int[] nums = new int[]{1, 2, 3, 4};
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>(new ArrayList<>());
            }
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i <= nums.length; i++) {
                backtracking(nums, i, 0, res, tempList);
            }
            return res;
        }

        private void backtracking(int[] nums, int k, int index, List<List<Integer>> res, List<Integer> tempList) {
            if (tempList.size() == k) {
                res.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = index; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtracking(nums, k, i + 1, res, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}