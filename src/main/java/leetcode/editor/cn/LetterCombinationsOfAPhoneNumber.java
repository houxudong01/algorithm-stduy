//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 题目编号：17
// https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
@SuppressWarnings("all")
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits == null || digits.equals("") || digits.contains("1") || digits.contains("0")) {
                return res;
            }
            String[] keys = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            dfs(new StringBuilder(), res, digits, keys);
            return res;
        }

        public void dfs(StringBuilder prefix, List<String> res, final String digits, String[] keys) {
            if (prefix.length() == digits.length()) {
                res.add(prefix.toString());
                return;
            }
            int curDigit = digits.charAt(prefix.length()) - '0';
            for (char c : keys[curDigit].toCharArray()) {
                prefix.append(c);
                dfs(prefix, res, digits, keys);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}