//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
//
// 示例 1: 
//
// 
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
// 
//
// 示例 2: 
//
// 
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 注意: 
//
// 
// 输入的字符串长度不会超过1000。 
// 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;

// 题目编号：647
// https://leetcode-cn.com/problems/palindromic-substrings/
@SuppressWarnings("all")
public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int result = 0;

        public int countSubstrings(String s) {
            for (int i = 0; i < s.length(); i++) {
                // 奇数长度
                extend(s, i, i);
                // 偶数长度
                extend(s, i, i + 1);
            }
            return result;
        }

        private void extend(String s, int start, int end) {
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                result++;
                start--;
                end++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}