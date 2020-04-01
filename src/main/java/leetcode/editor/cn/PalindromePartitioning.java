//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 题目编号：131
// https://leetcode-cn.com/problems/palindrome-partitioning/
@SuppressWarnings("all")
public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        System.out.println(solution.partition("aabaa"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            if (s == null || "".equals(s)) {
                return new ArrayList<>(new ArrayList<>());
            }
            List<List<String>> res = new ArrayList<>();
            List<String> tempList = new ArrayList<>();

            backtracking(s, 0, res, tempList);
            return res;
        }

        private void backtracking(String s, int start, List<List<String>> res, List<String> tempList) {
            if (s.length() == start) {
                res.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = start; i < s.length(); i++) {
                String substring = s.substring(start, i + 1);
                if (isPalindrome(substring)) {
                    tempList.add(substring);
                    backtracking(s, start + substring.length(), res, tempList);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s) {
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}