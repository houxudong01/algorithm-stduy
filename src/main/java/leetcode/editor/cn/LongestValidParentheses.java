//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划

package leetcode.editor.cn;

import java.util.Stack;

// 题目编号：32
// https://leetcode-cn.com/problems/longest-valid-parentheses/
@SuppressWarnings("all")
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        String s = "(()())";
        System.out.println(solution.longestValidParentheses(s));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            char[] chars = s.toCharArray();
            int maxL = 0;
            int left = 0;
            int right = 0;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    maxL = Math.max(maxL, 2 * left);
                } else if (right > left) {
                    right = left = 0;
                }
            }
            left = right = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                if (left > right) {
                    maxL = Math.max(maxL, 2 * right);
                    left = right = 0;
                }
                char c = chars[i];
                if (c == ')') {
                    right++;
                } else {
                    left++;
                }
                if (left == right) {
                    maxL = Math.max(maxL, 2 * right);
                } else if (left > right) {
                    left = right = 0;
                }
            }
            return maxL;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}