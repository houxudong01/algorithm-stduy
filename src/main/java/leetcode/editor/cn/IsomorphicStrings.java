//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

// 题目编号：205
// https://leetcode-cn.com/problems/isomorphic-strings/
@SuppressWarnings("all")
public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
        String s = "ab";
        String t = "aa";
        System.out.println(solution.isIsomorphic(s, t));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 方法1
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            // s中字符和t中字符的映射关系
            Map<Character, Character> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char sc = s.charAt(i);
                char tc = t.charAt(i);

                if (!map.containsKey(sc)) {
                    // 两个字符不允许映射到同一个字符上
                    if (map.containsValue(tc)) {
                        return false;
                    }
                    map.put(sc, tc);
                } else {
                    if (map.get(sc) != tc) {
                        return false;
                    }
                }
            }
            return true;
        }

        // 方法2
        public boolean isIsomorphic2(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            // 记录s中每个字符上次出现的位置
            int[] sArray = new int[128];
            // 记录t中每个字符上次出现的位置
            int[] tArray = new int[128];
            for (int i = 0; i < s.length(); i++) {
                char sc = s.charAt(i);
                char tc = t.charAt(i);
                if (sArray[sc] != tArray[tc]) {
                    return false;
                }
                // 同步前移
                sArray[sc] = i + 1;
                tArray[tc] = i + 1;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}