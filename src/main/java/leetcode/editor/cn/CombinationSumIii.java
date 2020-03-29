//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 题目编号：216
// https://leetcode-cn.com/problems/combination-sum-iii/
@SuppressWarnings("all")
public class CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
        System.out.println(solution.combinationSum3(3, 7));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tempList = new ArrayList<>();
            backtracking(k, n, res, tempList, 1);
            return res;
        }

        private void backtracking(int k, int n, List<List<Integer>> res, List<Integer> tempList, int index) {
            if (n == 0 && tempList.size() == k) {
                res.add(new ArrayList<>(tempList));
                return;
            }
            if (n < 0 || tempList.size() >= k) {
                return;
            }
            for (int i = index; i <= 9; i++) {
                if (n - i < 0) {
                    break;
                }

                tempList.add(i);
                backtracking(k, n - i, res, tempList, i + 1);
                tempList.remove(tempList.size() - 1);

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}