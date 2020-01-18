//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 示例 1: 
//
// 输入: "hello"
//输出: "holle"
// 
//
// 示例 2: 
//
// 输入: "leetcode"
//输出: "leotcede" 
//
// 说明: 
//元音字母不包含字母"y"。 
// Related Topics 双指针 字符串


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

// 题目编号：345
// https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
@SuppressWarnings("all")
public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            Set<Character> set = new HashSet<>(Arrays.asList('a', 'o', 'e', 'i', 'u', 'A', 'O', 'E', 'I', 'U'));
            char[] chars = s.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while (i <= j) {
                boolean containsI = set.contains(chars[i]);
                boolean containsJ = set.contains(chars[j]);
                if (containsI && containsJ) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    i++;
                    j--;
                } else if (containsI) {
                    j--;
                } else if (containsJ) {
                    i++;
                } else {
                    i++;
                    j--;
                }
            }
            return String.valueOf(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}