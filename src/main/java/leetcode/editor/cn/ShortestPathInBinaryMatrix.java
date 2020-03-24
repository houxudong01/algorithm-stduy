//在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。 
//
// 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成： 
//
// 
// 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角） 
// C_1 位于 (0, 0)（即，值为 grid[0][0]） 
// C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]） 
// 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0） 
// 
//
// 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：[[0,1],[1,0]]
//
//输出：2
//
// 
//
// 示例 2： 
//
// 输入：[[0,0,0],[1,1,0],[1,1,0]]
//
//输出：4
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

// 题目编号：1091
// https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
@SuppressWarnings("all")
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new ShortestPathInBinaryMatrix().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid == null || grid.length < 1 || grid[0][0] == 1) {
                return -1;
            }
            int m = grid.length;
            int n = grid[0].length;
            int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            int step = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = queue.poll();
                    if (cur[0] == m - 1 && cur[1] == n - 1) {
                        return step;
                    }
                    for (int[] dir : directions) {
                        int x = cur[0] + dir[0];
                        int y = cur[1] + dir[1];
                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 1) {
                            continue;
                        }
                        queue.add(new int[]{x, y});
                        grid[x][y] = 1;
                    }
                }
                step++;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}