//给定一个包含了一些 0 和 1 的非空二维数组 grid 。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。) 
//
// 
//
// 示例 1: 
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// [[0,0,0,0,0,0,0,0]] 
//
// 对于上面这个给定的矩阵, 返回 0。 
//
// 
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。 
// Related Topics 深度优先搜索 数组


package leetcode.editor.cn;

// 题目编号：695
// https://leetcode-cn.com/problems/max-area-of-island/
@SuppressWarnings("all")
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new MaxAreaOfIsland().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int area = 0;
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    area = Math.max(area, dfs(grid, i, j, directions));
                }
            }
            return area;
        }

        private int dfs(int[][] grid, int r, int c, int[][] directions) {
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
                return 0;
            }
            grid[r][c] = 0;
            int area = 1;
            for (int[] dir : directions) {
                area += dfs(grid, r + dir[0], c + dir[1], directions);
            }
            return area;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}