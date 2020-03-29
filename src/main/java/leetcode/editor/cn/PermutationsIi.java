//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 题目编号：47
// https://leetcode-cn.com/problems/permutations-ii/
@SuppressWarnings("all")
public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] nums = new int[]{1, 1, 2};
        System.out.println(solution.permuteUnique(nums));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>(new ArrayList<>());
            }
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tempList = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            backtracking(tempList, res, visited, nums);
            return res;
        }

        public void backtracking(List<Integer> tempList, List<List<Integer>> res, boolean[] visited, final int[] nums) {
            if (tempList.size() == nums.length) {
                res.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] || (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])) {
                    continue;
                }
                visited[i] = true;
                tempList.add(nums[i]);
                backtracking(tempList, res, visited, nums);
                tempList.remove(tempList.size() - 1);
                visited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}