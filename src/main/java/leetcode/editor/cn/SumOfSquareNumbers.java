//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。 
//
// 示例1: 
//
// 
//输入: 5
//输出: True
//解释: 1 * 1 + 2 * 2 = 5
// 
//
// 
//
// 示例2: 
//
// 
//输入: 3
//输出: False
// 
// Related Topics 数学


package leetcode.editor.cn;

// 题目编号：633
// https://leetcode-cn.com/problems/sum-of-square-numbers/
@SuppressWarnings("all")
public class SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfSquareNumbers().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            if (c < 0) {
                return false;
            }
            int i = 0;
            int j = (int) Math.sqrt(c);
            while (i <= j) {
                int sum = i * i + j * j;
                if (sum == c) {
                    return true;
                }
                if (sum < c) {
                    i++;
                } else {
                    j--;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}