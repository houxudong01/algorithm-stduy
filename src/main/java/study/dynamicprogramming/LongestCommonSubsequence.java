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
        int[][] dp = new int[m + 1][n + 1];

        // 初始化第 0 行
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        // 初始化第 0 列
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        // 计算各子序列长度
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 打印出 dp 数组
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("打印最长子序列");
        printLcs(dp, a, m, b, n);
        System.out.println();
        return dp[m][n];
    }

    /**
     * 打印最长公共子序列
     *
     * @param dp
     * @param a
     * @param m
     * @param b
     * @param n
     */
    private static void printLcs(int[][] dp, char[] a, int m, char[] b, int n) {
        if (m < 1 || n < 1) {
            return;
        }

        // 检查到lcs为1并且字符串a和b对应位置字符相同时返回
        if (dp[m][n] == 1 && a[m - 1] == b[n - 1]) {
            System.out.print(a[m - 1] + " ");
            return;
        }
        // 字符串a和b对应位置字符不同时，倒推到来源值较大的一个可达位置
        if (a[m - 1] != b[n - 1]) {
            if (dp[m - 1][n] < dp[m][n - 1]) {
                printLcs(dp, a, m, b, n - 1);
            } else if (dp[m - 1][n] >= dp[m][n - 1]) {
                printLcs(dp, a, m - 1, b, n);
            }
        } else {
            printLcs(dp, a, m - 1, b, n - 1);
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
