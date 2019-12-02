//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找

package leetcode.editor.cn;

// 题目编号：69
// https://leetcode-cn.com/problems/sqrtx/
@SuppressWarnings("all")
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt(8));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x == 1) {
                return 1;
            }
            int i = 0;
            int j = x;
            while (j - i > 1) {
               int m = i + ((j - i) >> 1);
                if (x / m < m) {
                    j = m;
                } else {
                    i = m;
                }
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}