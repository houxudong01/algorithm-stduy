//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
// Related Topics 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 题目编号：51
// https://leetcode-cn.com/problems/n-queens/
@SuppressWarnings("all")
public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        solution.solveNQueens(8);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<String>> res = new ArrayList<>();
        private int[] result;

        public List<List<String>> solveNQueens(int n) {
            result = new int[n];
            backtracking(n, 0);
            return res;
        }

        private void backtracking(int n, int row) {
            if (row >= n) {
                List<String> tempList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        if (result[i] == j) {
                            sb.append("Q");
                        } else {
                            sb.append(".");
                        }
                    }
                    tempList.add(sb.toString());
                }
                res.add(tempList);
                return;
            }
            for (int col = 0; col < n; col++) {
                if (isOk(row, col, n)) {
                    result[row] = col;
                    backtracking(n, row + 1);
                }
            }
        }

        private boolean isOk(int row, int col, int n) {
            int r = row - 1;
            int leftC = col - 1;
            int rightC = col + 1;
            while (r >= 0) {
                if (result[r] == col) {
                    return false;
                }
                if (leftC >= 0 && result[r] == leftC) {
                    return false;
                }
                if (rightC < n && result[r] == rightC) {
                    return false;
                }
                leftC--;
                rightC++;
                r--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}