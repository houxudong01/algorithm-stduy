//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 题目编号：77
// https://leetcode-cn.com/problems/combinations/
@SuppressWarnings("all")
public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        System.out.println(solution.combine(4, 2));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            int[] nums = new int[n];
            for (int i = 1; i <= n; i++) {
                nums[i - 1] = i;
            }
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tempList = new ArrayList<>();
            backtracking(nums, res, tempList, 0, k);
            return res;
        }

        private void backtracking(int[] nums, List<List<Integer>> res, List<Integer> tempList, int s, int k) {
            if (tempList.size() == k) {
                res.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = s; i < nums.length; i++) {
                tempList.add(nums[i]);
                int nextS = i + 1;
                backtracking(nums, res, tempList, nextS, k);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}