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
        solution.solveNQueens(4);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] result;
        private List<List<String>> r = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            result = new int[n];
            f(0, n);
            return r;
        }

        private void f(int row, int n) {
            // 一趟考察结束，记录结果
            if (row == n) {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        if (result[i] == j) {
                            sb.append("Q");
                        } else {
                            sb.append(".");
                        }
                    }
                    list.add(sb.toString());
                }
                r.add(list);
                return;
            }
            // 检查该行每列的位置
            for (int column = 0; column < n; column++) {
                if (isOk(row, column, n)) {
                    result[row] = column;
                    f(row + 1, n);
                }
            }
        }

        private boolean isOk(int row, int column, int n) {
            int leftCol = column - 1;
            int rightCol = column + 1;
            for (int i = row - 1; i >= 0; i--) {
                if (result[i] == column) {
                    return false;
                }
                if (leftCol >= 0 && result[i] == leftCol) {
                    return false;
                }
                if (rightCol < n && result[i] == rightCol) {
                    return false;
                }
                leftCol--;
                rightCol++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}