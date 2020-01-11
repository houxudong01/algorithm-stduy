//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。 
//请注意，它是排序后的第k小元素，而不是第k个元素。 
//
// 示例: 
//
// 
//matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
// 
//
// 说明: 
//你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。 
// Related Topics 堆 二分查找

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

// 题目编号：378
// https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
@SuppressWarnings("all")
public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(solution.kthSmallest(matrix, 8));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {

            int m = matrix.length;
            int n = matrix[0].length;
            int l = matrix[0][0];
            int h = matrix[m - 1][n - 1];
            while (l <= h) {
                int mid = l + ((h - l) >> 1);
                // 计算小于等于 mid 值的数的个数
                int cnt = 0;
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                        cnt++;
                    }
                }

                if (cnt < k) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}