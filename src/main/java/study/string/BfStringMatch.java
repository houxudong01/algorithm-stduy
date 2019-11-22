package study.string;

/**
 * 字符串朴素匹配算法
 *
 * @author:hxd
 * @date:2019/11/7
 */
public class BfStringMatch {

    /**
     * 在字符串 a 中查找字符串 b 出现的第一个位置
     *
     * @param a 主串
     * @param b 模式串
     * @return
     */
    public static int match(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        out:
        for (int i = 0; i < aChars.length - bChars.length + 1; i++) {
            int j = 0, k = i;
            for (; j < bChars.length; j++, k++) {
                // 也可以不用声明变量 k ,这样下面的判断表达式就可以修改为 (bChars[j] != aChars[i+j])
                if (bChars[j] != aChars[k]) {
                    continue out;
                }
            }
            if (j == bChars.length) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "abcdef";
        String b = "cd";
        System.out.println(match(a, b));
    }
}
