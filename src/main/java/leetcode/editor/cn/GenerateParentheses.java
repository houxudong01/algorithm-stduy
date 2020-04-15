//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

// 题目编号：22
// https://leetcode-cn.com/problems/generate-parentheses/
@SuppressWarnings("all")
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            if (n < 1) {
                return new ArrayList<>();
            }
            List<String> res = new ArrayList<>();
            backtracking(n, res, new StringBuilder(), 0, 0);
            return res;
        }

        /**
         * 回溯实现
         *
         * @param n          括号对数
         * @param res        存放结构的list
         * @param sb         生成的临时字符串
         * @param leftCount  左括号数
         * @param rightCount 右括号数
         */
        private void backtracking(int n, List<String> res, StringBuilder sb, int leftCount, int rightCount) {
            // 剪枝，右括号数大于左括号数已经没救了
            if (rightCount > leftCount) {
                return;
            }
            // 字符串长度达到最大值了
            if (sb.length() == 2 * n) {
                // 左括号数等于右括号数，满足有效条件
                if (leftCount == rightCount) {
                    res.add(sb.toString());
                }
                return;
            }
            if (leftCount < n) {
                // 加一个左括号
                backtracking(n, res, sb.append("("), leftCount + 1, rightCount);
                // 恢复
                sb.delete(sb.length() - 1, sb.length());
            }
            if (rightCount < n) {
                // 加一个右括号
                backtracking(n, res, sb.append(")"), leftCount, rightCount + 1);
                // 恢复
                sb.delete(sb.length() - 1, sb.length());
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}