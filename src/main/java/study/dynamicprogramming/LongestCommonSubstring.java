package study.dynamicprogramming;

/**
 * 最长公共子串（要求字符必须连续）
 * 参考：https://www.cnblogs.com/wangkundentisy/p/9346376.html
 *
 * @author:hxd
 * @date:2019/11/23
 */
public class LongestCommonSubstring {
    /**
     * 求两个字符串的最大公共子串长度
     *
     * @param a
     * @param m
     * @param b
     * @param n
     * @return
     */
    public static int lcs(char[] a, int m, char[] b, int n) {
        // 记录最长公共子串长度
        int[][] c = new int[m + 1][n + 1];
        // 初始化第 0 行 0 列
        for (int j = 0; j <= n; j++) {
            c[0][j] = 0;
        }
        for (int i = 0; i <= m; i++) {
            c[i][0] = 0;
        }

        // 最长公共子串的长度
        int maxLen = 0;
        // 最长公共子串在a串中的最后一个字符的位置
        int endIndex = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1] == b[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    // 每次更新记录最大值
                    if (c[i][j] > maxLen) {
                        maxLen = c[i][j];
                        endIndex = i - 1;
                    }
                } else {
                    c[i][j] = 0;
                }
            }
        }

        // 打印最长公共子串
        for (int i = endIndex - maxLen + 1; i <= endIndex; i++) {
            System.out.print(a[i] + " ");
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String a = "abcdfg";
        String b = "abdcdf";
        System.out.println(lcs(a.toCharArray(), a.length(), b.toCharArray(), b.length()));
    }

}
