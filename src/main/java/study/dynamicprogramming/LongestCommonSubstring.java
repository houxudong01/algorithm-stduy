package study.dynamicprogramming;

/**
 * 计算最长公共子串长度
 *
 * @author:hxd
 * @date:2019/11/22
 */
public class LongestCommonSubstring {

    public int lcs(char[] a, int m, char[] b, int n) {
        int[][] maxLcs = new int[m][n];
        // 初始化第 0 行：a[0]与b[0...j]的最长公共子串长度
        for (int j = 0; j < n; j++) {
            if (a[0] == b[j]) {
                maxLcs[0][j] = 1;
            } else if (j != 0) {
                maxLcs[0][j] = maxLcs[0][j - 1];
            } else {
                maxLcs[0][j] = 0;
            }
        }

        // 初始化第 0 列：a[0...i]与b[0]的最长公共子串长度
        for (int i = 0; i < m; i++) {
            if (b[0] == a[i]) {
                maxLcs[i][0] = 1;
            } else if (i != 0) {
                maxLcs[i][0] = maxLcs[i - 1][0];
            } else {
                maxLcs[i][0] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i] == b[j]) {
                    maxLcs[i][j] = max(maxLcs[i - 1][j], maxLcs[i][j - 1], maxLcs[i - 1][j - 1] + 1);
                } else {
                    maxLcs[i][j] = max(maxLcs[i - 1][j], maxLcs[i][j - 1], maxLcs[i - 1][j - 1]);
                }
            }
        }
        return maxLcs[m - 1][n - 1];
    }

    /**
     * 求 x、y、z 中的最大值
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    private int max(int x, int y, int z) {
        int maxV = Integer.MIN_VALUE;
        if (x > maxV) {
            maxV = x;
        }
        if (y > maxV) {
            maxV = y;
        }
        if (z > maxV) {
            maxV = z;
        }
        return maxV;
    }
}
