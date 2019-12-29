//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表

package leetcode.editor.cn;

// 题目编号：409
// https://leetcode-cn.com/problems/longest-palindrome/
@SuppressWarnings("all")
public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
        System.out.println(solution.longestPalindrome("FFabccccddAA"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            // 申请一个数组，记录字符串中出现的大写字母和小写字母的出现次数，
            // 下标是字母对应的ASCII十进制值
            int[] count = new int[128];
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                count[aChar]++;
            }
            int maxL = 0;
            for (int c : count) {
                // 如果某个字符出现次数是偶数，那么这个次数可以构建回文串
                // 如果是奇数，那么需要减去 1 来构建回文字符串
                maxL += ((c / 2) * 2);
            }
            // 最后如果还剩单个字符，那么可以放到字符串中间构建回文字符串
            if (maxL < s.length()) {
                maxL++;
            }
            return maxL;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}