//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 题目编号：279
// https://leetcode-cn.com/problems/perfect-squares/
@SuppressWarnings("all")
public class PerfectSquares {
    public static void main(String[] args) {
        Solution soluton = new PerfectSquares().new Solution();
        System.out.println(soluton.numSquares(12));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            List<Integer> squares = generateSquares(n);
            Queue<Integer> queue = new LinkedList<>();
            boolean[] marked = new boolean[n + 1];
            queue.add(n);
            marked[n] = true;
            int level = 0;
            while (!queue.isEmpty()) {
                level++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer cur = queue.poll();
                    for (Integer square : squares) {
                        int next = cur - square;
                        if (next < 0) {
                            break;
                        }
                        if (next == 0) {
                            return level;
                        }
                        if (marked[next]) {
                            continue;
                        }
                        marked[next] = true;
                        queue.add(next);
                    }
                }
            }
            return n;
        }

        private List<Integer> generateSquares(int n) {
            List<Integer> squares = new ArrayList<>();
            int square = 1;
            int diff = 3;
            while (square <= n) {
                squares.add(square);
                square += diff;
                diff += 2;
            }
            return squares;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}