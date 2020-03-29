//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 题目编号：39
// https://leetcode-cn.com/problems/combination-sum/
@SuppressWarnings("all")
public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates == null || candidates.length == 0) {
                return new ArrayList<>(new ArrayList<>());
            }
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tempList = new ArrayList<>();
            backtracking(res, tempList, candidates, 0, target);
            return res;
        }

        private void backtracking(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int start, int target) {
            if (target == 0) {
                res.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    tempList.add(candidates[i]);
                    backtracking(res, tempList, candidates, i, target - candidates[i]);
                    tempList.remove(tempList.size() - 1);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}