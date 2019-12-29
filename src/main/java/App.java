/**
 * @author:hxd
 * @date:2019/12/29
 */
public class App {
    public static void main(String[] args) {

    }

    public static String longestPalindrome(String s) {

        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        s = sb.toString();

        int rightSide = 0;
        int rightSideCenter = 0;
        int center = 0;
        int maxHalfLength = 0;
        int[] halfLength = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            boolean needExtend = true;
            if (i < rightSide) {
                int left = 2 * rightSideCenter - i;
                halfLength[i] = halfLength[left];
                if (i + halfLength[i] > rightSide) {
                    halfLength[i] = rightSide - i;
                }
                if (i + halfLength[i] < rightSide) {
                    needExtend = false;
                }
            }
            if (needExtend) {
                while (i - 1 - halfLength[i] >= 0 && i + 1 + halfLength[i] < s.length()) {
                    if (s.charAt(i - 1 - halfLength[i]) == s.charAt(i + 1 + halfLength[i])) {
                        halfLength[i]++;
                    } else {
                        break;
                    }
                }
                rightSide = i + halfLength[i];
                rightSideCenter = i;
                if (halfLength[i] > maxHalfLength) {
                    maxHalfLength = halfLength[i];
                    center = i;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = center - maxHalfLength + 1; i < center + maxHalfLength; i += 2) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
