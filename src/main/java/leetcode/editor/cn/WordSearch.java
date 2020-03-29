//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法


package leetcode.editor.cn;

// 题目编号：79
// https://leetcode-cn.com/problems/word-search/
@SuppressWarnings("all")
public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution.exist(board, "ABAB"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean exist = false;

        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == word.toCharArray()[0]) {
                        dfs(board, i, j, word.toCharArray(), 0);
                    }
                }
            }
            return exist;
        }

        private void dfs(char[][] board, int i, int j, char[] chars, int charIndex) {
            if (chars.length == charIndex) {
                exist = true;
                return;
            }
            if (exist || i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != chars[charIndex]) {
                return;
            }

            int nextCharIndex = charIndex + 1;
            char t = board[i][j];
            board[i][j] = '-';
            dfs(board, i - 1, j, chars, nextCharIndex);
            dfs(board, i + 1, j, chars, nextCharIndex);
            dfs(board, i, j - 1, chars, nextCharIndex);
            dfs(board, i, j + 1, chars, nextCharIndex);
            board[i][j] = t;
            if (nextCharIndex == chars.length) {
                exist = true;
                return;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}