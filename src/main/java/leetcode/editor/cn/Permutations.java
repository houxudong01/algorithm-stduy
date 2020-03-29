//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 题目编号：46
// https://leetcode-cn.com/problems/permutations/
@SuppressWarnings("all")
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>(new ArrayList<>());
            }
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tempList = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            backtriacking(tempList, res, visited, nums);
            return res;
        }

        private void backtriacking(List<Integer> tempList, List<List<Integer>> res, boolean[] visited, final int[] nums) {
            if (tempList.size() == nums.length) {
                res.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                tempList.add(nums[i]);
                backtriacking(tempList, res, visited, nums);
                tempList.remove(tempList.size() - 1);
                visited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}