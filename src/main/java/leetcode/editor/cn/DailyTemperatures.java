//根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表

package leetcode.editor.cn;

import java.util.Stack;

// 题目编号：739
// https://leetcode-cn.com/problems/daily-temperatures/
@SuppressWarnings("all")
public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            int[] result = new int[T.length];
            Stack<Integer> stack = new Stack<>();
            for (int curIndex = 0; curIndex < T.length; curIndex++) {
                while (!stack.isEmpty() && T[curIndex] > T[stack.peek()]) {
                    Integer preIndex = stack.pop();
                    result[preIndex] = curIndex - preIndex;
                }
                stack.push(curIndex);
            }
            return result;
        }

        public int[] dailyTemperatures2(int[] T) {
            int[] result = new int[T.length];
            result[T.length - 1] = 0;
            for (int i = T.length - 2; i >= 0; i--) {
                for (int j = i + 1; j < T.length; j = j + result[j]) {
                    if (T[i] < T[j]) {
                        result[i] = j - i;
                        break;
                    } else if (result[j] == 0) {
                        result[i] = 0;
                        break;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}