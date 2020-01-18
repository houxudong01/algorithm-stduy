//给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符
//串。如果答案不存在，则返回空字符串。 
//
// 示例 1: 
//
// 
//输入:
//s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//输出: 
//"apple"
// 
//
// 示例 2: 
//
// 
//输入:
//s = "abpcplea", d = ["a","b","c"]
//
//输出: 
//"a"
// 
//
// 说明: 
//
// 
// 所有输入的字符串只包含小写字母。 
// 字典的大小不会超过 1000。 
// 所有输入的字符串长度不会超过 1000。 
// 
// Related Topics 排序 双指针


package leetcode.editor.cn;

import sun.tools.jconsole.Worker;

import java.util.List;

// 题目编号：524
// https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
@SuppressWarnings("all")
public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> d) {
            String longestWord = "";
            for (String target : d) {
                int l1 = longestWord.length();
                int l2 = target.length();
                if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                    continue;
                }
                if (isSubSequence(s, target)) {
                    longestWord = target;
                }
            }
            return longestWord;
        }

        // 判断 target 是否为 s 的子序列
        private boolean isSubSequence(String s, String target) {
            int i = 0;
            int j = 0;
            while (i < s.length() && j < target.length()) {
                if (s.charAt(i) == target.charAt(j)) {
                    j++;
                }
                i++;
            }
            return j == target.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}