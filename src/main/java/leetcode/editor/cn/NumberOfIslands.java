//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package leetcode.editor.cn;

// 题目编号：200
// https://leetcode-cn.com/problems/number-of-islands/
@SuppressWarnings("all")
public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j, directions);
                        res++;
                    }
                }
            }
            return res;
        }

        public void dfs(char[][] grid, int i, int j, int[][] directions) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            for (int[] dir : directions) {
                dfs(grid, i + dir[0], j + dir[1], directions);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}