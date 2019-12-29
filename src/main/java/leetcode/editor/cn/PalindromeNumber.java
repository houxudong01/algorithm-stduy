//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学

package leetcode.editor.cn;

// 题目编号：9
// https://leetcode-cn.com/problems/palindrome-number/
@SuppressWarnings("all")
public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome2(12344321));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            Integer num = x;
            String s1 = num.toString();
            char[] chars = s1.toCharArray();
            int length = chars.length;
            for (int i = 0; i < length / 2; i++) {
                char temp = chars[i];
                chars[i] = chars[length - i - 1];
                chars[length - i - 1] = temp;
            }
            String s2 = String.valueOf(chars);
            return s1.equals(s2);
        }

        public boolean isPalindrome2(int x) {
            if (x == 0) {
                return true;
            }
            if (x < 0 || x % 10 == 0) {
                return false;
            }
            int right = 0;
            while (x > right) {
                right = right * 10 + x % 10;
                x /= 10;
            }
            return x == right || x == right / 10;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}