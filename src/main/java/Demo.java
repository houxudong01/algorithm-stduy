import java.util.*;

/**
 * @author:hxd
 * @date:2020/4/4
 */
public class Demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Stack<Character> queue = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '/' && !queue.isEmpty() && queue.peek() == '/') {
                i++;
                continue;
            }
            if (c != '.') {
                queue.add(c);
                i++;
            } else if (i + 1 < s.length() && s.charAt(i + 1) == '.') {
                queue.pop();
                queue.pop();
                i += 2;
            } else {
                queue.pop();
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : queue) {
            sb.append(character.charValue());
        }
        System.out.println(sb.toString());
    }
}
