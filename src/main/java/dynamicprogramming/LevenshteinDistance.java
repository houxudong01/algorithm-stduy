package dynamicprogramming;

/**
 * 莱维斯坦编辑距离(Levenshtein distance)
 *
 * @author:hxd
 * @date:2019/11/22
 */
public class LevenshteinDistance {

    /**
     * 计算两个字符串的莱文斯坦编辑距离
     *
     * @param a 字符串a
     * @param m a串的长度
     * @param b 字符串b
     * @param n b串的长度
     * @return
     */
    public int lwsBt(char[] a, int m, char[] b, int n) {
        // 编辑距离表,例如：minDist[i][j] = dist，表示处理到a[i]和b[j]时，已经执行的编辑操作的次数
        int[][] minDist = new int[m][n];
        // 初始化第 0 行：a[0] 与 b[0...j] 的编辑距离
        for (int j = 0; j < n; j++) {
            if (a[0] == b[j]) {
                minDist[0][j] = j;
            } else if (j != 0) {
                minDist[0][j] = minDist[0][j - 1] + 1;
            } else {
                minDist[0][j] = 1;
            }
        }

        // 初始化第 0 列：a[0...i] 与 b[0]的编辑距离
        for (int i = 0; i < m; i++) {
            if (b[0] == a[i]) {
                minDist[i][0] = i;
            } else if (i != 0) {
                minDist[i][0] = minDist[i - 1][0] + 1;
            } else {
                minDist[i][0] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i] == b[j]) {
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i][j]);
                } else {
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i][j] + 1);
                }
            }
        }
        return minDist[m - 1][n - 1];
    }

    /**
     * 求 x、y、z 中的最小值
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    private int min(int x, int y, int z) {
        int minV = Integer.MAX_VALUE;
        if (x < minV) {
            minV = x;
        }
        if (y < minV) {
            minV = y;
        }
        if (z < minV) {
            minV = z;
        }
        return minV;
    }
}
