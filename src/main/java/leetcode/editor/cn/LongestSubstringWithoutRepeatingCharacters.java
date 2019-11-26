//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package leetcode.editor.cn;

// 题目编号：3
// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
@SuppressWarnings("all")
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcdecdefgh"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 记录遍历到下标-1位置时最长的不重复子串长度
            int[] maxLength = new int[s.length() + 1];
            // 不重复子串的开始位置
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                // 此刻的最大不重复子串是否包含 当前遍历到的字符，如果包含，则说明重复了，需要更新 start
                if (s.substring(start, i).indexOf(currentChar) != -1) {
                    start = s.indexOf(currentChar, start) + 1;
                }
                maxLength[i + 1] = Math.max(maxLength[i], i - start + 1);
            }

            // 打印最长不重复的子串
            for (int i = s.length(); i >= 0; i--) {
                // 找到最长不重复子串的结束位置i，对应在s中是i-1
                if (maxLength[i] > maxLength[i - 1]) {
                    // （i - 子串长度）就是子串的开始位置
                    for (int j = i - maxLength[s.length()]; j < i; j++) {
                        System.out.print(s.charAt(j));
                    }
                    System.out.println();
                    break;
                }
            }

            return maxLength[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}