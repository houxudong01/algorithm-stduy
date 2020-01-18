//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串


package leetcode.editor.cn;

// 题目编号：680
// https://leetcode-cn.com/problems/valid-palindrome-ii/
@SuppressWarnings("all")
public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
        System.out.println(solution.validPalindrome("deeee"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            char[] chars = s.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while (i < j) {
                if (chars[i] != chars[j]) {
                    return isPalindrome(chars, i + 1, j) || isPalindrome(chars, i, j - 1);
                }
                i++;
                j--;
            }
            return true;
        }

        private boolean isPalindrome(char[] chars, int i, int j) {
            while (i < j) {
                if (chars[i++] != chars[j--]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}