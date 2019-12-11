//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 题目编号：120
// https://leetcode-cn.com/problems/triangle/
@SuppressWarnings("all")
public class Triangle {
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
        List<List<Integer>> trangle = new ArrayList<>();

        List<Integer> list0 = new ArrayList<>();
        list0.add(2);
        trangle.add(list0);
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        trangle.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        trangle.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);
        trangle.add(list3);
        System.out.println(solution.minimumTotal(trangle));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle.isEmpty()) {
                return 0;
            }
            int length = triangle.size();
            int[][] dp = new int[length][length];
            dp[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < length; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                    } else if (j == triangle.get(i).size() - 1) {
                        dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            int i = length - 1;
            for (int j = 0; j < length; j++) {
                if (dp[i][j] < min) {
                    min = dp[i][j];
                }
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}