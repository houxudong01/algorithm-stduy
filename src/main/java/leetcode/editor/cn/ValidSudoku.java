//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表

package leetcode.editor.cn;

import sun.jvm.hotspot.ui.tree.BooleanTreeNodeAdapter;

// 题目编号：36
// https://leetcode-cn.com/problems/valid-sudoku/
@SuppressWarnings("all")
public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            // [i][num] 第 i 行是否已经存在 num 的记录
            boolean[][] row = new boolean[9][9];
            // [j][num] 第 j 列是否已经存在 num 的记录
            boolean[][] col = new boolean[9][9];
            // [index][num] 下标为 index 的 3x3 block内是否存在 num 的记录
            boolean[][] block = new boolean[9][9];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != '.') {
                        // 防止数组越界，所有元素都减去 '1' 转化成整型
                        int num = board[i][j] - '1';
                        int blockIndex = i / 3 * 3 + j / 3;
                        if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                            return false;
                        } else {
                            row[i][num] = true;
                            col[j][num] = true;
                            block[blockIndex][num] = true;
                        }
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}