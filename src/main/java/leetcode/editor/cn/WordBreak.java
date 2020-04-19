//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

// 题目编号：139
// https://leetcode-cn.com/problems/word-break/
@SuppressWarnings("all")
public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() == 0) {
                return false;
            }
            Set<String> dictSet = new HashSet<>(wordDict);
            int n = s.length();
            // dp[i] 表示s中以i-1位置处字符结尾的字符串是否可以被 wordDict 拆分
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && dictSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }

        /**
         * 递归回溯时间复杂度最坏为 O(N^N)，测试用例中会超时
         *
         * @param s
         * @param wordDict
         * @return
         */
        public boolean wordBreak2(String s, List<String> wordDict) {
            if (s == null || s.length() == 0) {
                return false;
            }
            return backtracking(s, wordDict, 0, new Boolean[s.length()]);
        }

        public boolean backtracking(String s, List<String> wordDict, int start, Boolean[] memo) {
            if (start == s.length()) {
                return true;
            }
            if (memo[start] != null) {
                return memo[start];
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDict.contains(s.substring(start, end)) && backtracking(s, wordDict, end, memo)) {
                    return memo[start] = true;
                }
            }
            return memo[start] = false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}