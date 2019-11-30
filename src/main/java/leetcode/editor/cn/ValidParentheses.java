//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

package leetcode.editor.cn;

import java.util.Stack;

// 题目编号：20
// https://leetcode-cn.com/problems/valid-parentheses/
@SuppressWarnings("all")
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        String s = "([)]";
        System.out.println(solution.isValid(s));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            s = s.replace(" ", "");
            while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
                s = s.replace("()", "");
                s = s.replace("{}", "");
                s = s.replace("[]", "");
            }
            if (s.equals("")) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}