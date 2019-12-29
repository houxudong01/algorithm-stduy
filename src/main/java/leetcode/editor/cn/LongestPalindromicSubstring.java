//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;

// 题目编号：5
// https://leetcode-cn.com/problems/longest-palindromic-substring/
// 参考：https://blog.csdn.net/csdnnews/article/details/82920678
@SuppressWarnings("all")
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("acbcdedcb"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            StringBuilder sb = new StringBuilder();
            sb.append("#");
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                sb.append("#");
            }
            s = sb.toString();

            // 回文子串的右边界
            int rightSide = 0;
            // 右边界对应回文子串的中心
            int rightSideCenter = 0;
            // 最长回文子串的中心
            int center = 0;
            // 最长回文子串长度的一半
            int maxHalfLength = 0;
            // 记录以每个字符为中心的回文子串的长度的一半
            int[] halfLength = new int[s.length()];

            for (int i = 0; i < s.length(); i++) {
                // 是否需要中心扩展
                boolean needExtend = true;
                // 如果当前字符在回文子串右边界的范围之内
                if (i < rightSide) {
                    // 计算 i 以 rightSideCenter 为中心的对称位置
                    int left = 2 * rightSideCenter - i;
                    // 根据回文特性，不需要重复计算就可以得出结论
                    halfLength[i] = halfLength[left];
                    // 超过右边界时需要重新调整
                    if (i + halfLength[i] > rightSide) {
                        halfLength[i] = rightSide - i;
                    }
                    // 以 i 为中心的回文子串长度小于右边界时不需要中心扩展
                    if (i + halfLength[i] < rightSide) {
                        needExtend = false;
                    }
                }
                // 中心扩展
                if (needExtend) {
                    // 判断 i 左右两边的字符是否满足回文子串的条件，并将此回文子串长度半数记录在 halfLength 中
                    while (i - 1 - halfLength[i] >= 0 && i + 1 + halfLength[i] < s.length()) {
                        if (s.charAt(i - 1 - halfLength[i]) == s.charAt(i + 1 + halfLength[i])) {
                            halfLength[i]++;
                        } else {
                            break;
                        }
                    }
                    // 更新右边界
                    rightSide = i + halfLength[i];
                    // 中心扩展
                    rightSideCenter = i;
                    // 记录最长回文子串长度半数和对应的中心位置
                    if (halfLength[i] > maxHalfLength) {
                        maxHalfLength = halfLength[i];
                        center = i;
                    }
                }
            }
            // 去掉之前加的#，并提取最长回文子串
            StringBuilder builder = new StringBuilder();
            for (int m = center - maxHalfLength + 1; m < center + maxHalfLength; m += 2) {
                builder.append(s.charAt(m));
            }
            return builder.toString();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}