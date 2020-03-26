//给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。 
//
// 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。 
//
// 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。 
//
// 
//
// 提示： 
//
// 
// 输出坐标的顺序不重要 
// m 和 n 都小于150 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//给定下面的 5x5 矩阵:
//
//  太平洋 ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
//
//返回:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 题目编号：417
// https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
@SuppressWarnings("all")
public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean flag = true;

        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            List<List<Integer>> res = new ArrayList<>();
            if (matrix == null || matrix.length == 0) {
                return res;
            }
            int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

            int m = matrix.length;
            int n = matrix[0].length;

            boolean[][] canReachP = new boolean[m][n];
            boolean[][] canReachA = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                dfs(matrix, i, 0, dirs, canReachP);
                dfs(matrix, i, n - 1, dirs, canReachA);
            }
            for (int j = 0; j < n; j++) {
                dfs(matrix, 0, j, dirs, canReachP);
                dfs(matrix, m - 1, j, dirs, canReachA);
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (canReachA[i][j] && canReachP[i][j]) {
                        res.add(Arrays.asList(i, j));
                    }
                }
            }
            return res;
        }

        private void dfs(int[][] matrix, int i, int j, int[][] dirs, boolean[][] canReach) {
            if (canReach[i][j]) {
                return;
            }
            canReach[i][j] = true;
            for (int[] dir : dirs) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                if (nextI < 0 || nextI >= matrix.length
                        || nextJ < 0 || nextJ >= matrix[0].length
                        || matrix[i][j] > matrix[nextI][nextJ]) {
                    continue;
                }
                dfs(matrix, nextI, nextJ, dirs, canReach);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}