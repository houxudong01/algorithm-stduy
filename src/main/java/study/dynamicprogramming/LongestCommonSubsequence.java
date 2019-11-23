package study.dynamicprogramming;

/**
 * 最长公共子序列（不要求字符连续）
 * 参考：https://blog.csdn.net/hrn1216/article/details/51534607
 *
 * @author:hxd
 * @date:2019/11/23
 */
public class LongestCommonSubsequence {

    /**
     * 获取两个字符串的最长公共子序列的长度
     *
     * @param a
     * @param m
     * @param b
     * @param n
     * @return 返回最长公共子序列长度
     */
    public static int lcs(char[] a, int m, char[] b, int n) {
        // 记录 a[1...m]和b[1...n]的 LCS 长度
        int[][] c = new int[m + 1][n + 1];

        // 初始化第 0 行
        for (int j = 0; j <= n; j++) {
            c[0][j] = 0;
        }
        // 初始化第 0 列
        for (int i = 0; i <= m; i++) {
            c[i][0] = 0;
        }
        // 计算各子序列长度病呢
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1] == b[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }

        // 打印出 c 数组
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("打印最长子序列");
        printLcs(c, a, m, b, n);
        System.out.println();
        return c[m][n];
    }

    /**
     * 打印最长公共子序列
     *
     * @param c
     * @param a
     * @param m
     * @param b
     * @param n
     */
    private static void printLcs(int[][] c, char[] a, int m, char[] b, int n) {
        if (m < 1 || n < 1) {
            return;
        }

        // 检查到lcs为1并且字符串a和b对应位置字符相同时返回
        if (c[m][n] == 1 && a[m - 1] == b[n - 1]) {
            System.out.print(a[m - 1] + " ");
            return;
        }
        // 字符串a和b对应位置字符不同时，倒推到来源值较大的一个可达位置
        if (a[m - 1] != b[n - 1]) {
            if (c[m - 1][n] < c[m][n - 1]) {
                printLcs(c, a, m, b, n - 1);
            } else if (c[m - 1][n] >= c[m][n - 1]) {
                printLcs(c, a, m - 1, b, n);
            }
        } else {
            printLcs(c, a, m - 1, b, n - 1);
            // 递归打印相同的序列字符，出栈后打印，保证有序
            System.out.print(a[m - 1] + " ");
        }
    }

    private static int max(int x, int y) {
        int maxV = Integer.MIN_VALUE;
        if (x > maxV) {
            maxV = x;
        }
        if (y > maxV) {
            maxV = y;
        }
        return maxV;
    }

    public static void main(String[] args) {
        String a = "mitcmu";
        String b = "mtacnu";
        System.out.println("字符串：" + a + " 和字符串：" + b + "的lcs：" + lcs(a.toCharArray(), a.length(), b.toCharArray(), b.length()));

        String e = "13456778";
        String f = "357486782";
        System.out.println("字符串：" + e + " 和字符串：" + f + "的lcs：" + lcs(e.toCharArray(), e.length(), f.toCharArray(), f.length()));

        String p = "abc";
        String q = "def";
        System.out.println("字符串：" + p + " 和字符串：" + q + "的lcs：" + lcs(p.toCharArray(), p.length(), q.toCharArray(), q.length()));

    }
}
