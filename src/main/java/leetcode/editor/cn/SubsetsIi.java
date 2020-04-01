//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 题目编号：90
// https://leetcode-cn.com/problems/subsets-ii/
@SuppressWarnings("all")
public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> subsets = solution.subsetsWithDup(nums);
        System.out.println(subsets);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>(new ArrayList<>());
            }
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tempList = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            for (int i = 0; i <= nums.length; i++) {
                backtracking(nums, i, 0, res, tempList, visited);
            }
            return res;
        }

        private void backtracking(int[] nums, int k, int index, List<List<Integer>> res, List<Integer> tempList, boolean[] visited) {
            if (tempList.size() == k) {
                res.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = index; i < nums.length; i++) {
//                if (i > index && nums[i - 1] == nums[i]) {
//                    continue;
//                }
                // 上面的if语句和下面的等价
                if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                    continue;
                }
                visited[i] = true;
                tempList.add(nums[i]);
                backtracking(nums, k, i + 1, res, tempList, visited);
                tempList.remove(tempList.size() - 1);
                visited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}