//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法


package leetcode.editor.cn;

// 题目编号：37
// https://leetcode-cn.com/problems/sudoku-solver/
@SuppressWarnings("all")
public class SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            if (board == null || board.length == 0) {
                return;
            }
            boolean[][] row = new boolean[9][9];
            boolean[][] colum = new boolean[9][9];
            boolean[][] block = new boolean[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '1';
                        row[i][num] = true;
                        colum[j][num] = true;
                        block[i / 3 * 3 + j / 3][num] = true;
                    }
                }
            }
            backtracking(board, 0, 0, row, colum, block);

        }

        private boolean backtracking(char[][] board, int i, int j, boolean[][] row, boolean[][] colum, boolean[][] block) {
            while (board[i][j] != '.') {
                if (++j >= 9) {
                    i++;
                    j = 0;
                }
                if (i >= 9) {
                    return true;
                }
            }

            for (int num = 0; num < 9; num++) {
                int blockIndex = i / 3 * 3 + j / 3;
                if (!row[i][num] && !colum[j][num] && !block[blockIndex][num]) {
                    board[i][j] = (char) ('1' + num);
                    row[i][num] = true;
                    colum[j][num] = true;
                    block[blockIndex][num] = true;
                    if (backtracking(board, i, j, row, colum, block)) {
                        return true;
                    } else {
                        board[i][j] = '.';
                        row[i][num] = false;
                        colum[j][num] = false;
                        block[blockIndex][num] = false;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}