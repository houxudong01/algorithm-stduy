package study.dynamicprogramming;

/**
 * 求最长不重复子串
 *
 * @author:hxd
 * @date:2020/8/1
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String a = "abcdeabcdef";
        System.out.println(lengthOfLongestSubstring(a));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 记录遍历到下标-1处位置时的最长不重复子串长度
        int[] maxLength = new int[s.length() + 1];
        // 不重复子串的开始位置
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            // 如果目前的不重复子串包含了当前字符，则需要更新 start 为重复字符首次出现位置+1
            if (s.substring(start, i).indexOf(current) != -1) {
                start = s.indexOf(current, start) + 1;
            }
            maxLength[i + 1] = Math.max(maxLength[i], i - start + 1);
        }

        // print
        for (int i = s.length(); i > 0; i--) {
            //  说明是最长不重复子串交界点
            if (maxLength[i] > maxLength[i - 1]) {
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
