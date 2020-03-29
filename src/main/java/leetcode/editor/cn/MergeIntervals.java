//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


package leetcode.editor.cn;

import java.util.*;

// 题目编号：56
// https://leetcode-cn.com/problems/merge-intervals/
@SuppressWarnings("all")
public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        int[][] intervals = new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        int[][] merge = solution.merge(intervals);
        System.out.println(merge);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return new int[][]{};
            }

            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            List<int[]> res = new ArrayList<>();
            int m = intervals.length;
            for (int i = 0; i < m; i++) {
                if (i == m - 1) {
                    res.add(intervals[i]);
                    break;
                }
                int curEnd = intervals[i][1];
                int nextStart = intervals[i + 1][0];
                // 当前区间的结尾大于等于下一个区间的开始
                if (curEnd >= nextStart) {
                    intervals[i + 1][0] = intervals[i][0];
                    intervals[i + 1][1] = Math.max(curEnd, intervals[i + 1][1]);
                } else {
                    res.add(intervals[i]);
                }
            }
            return res.toArray(new int[][]{});
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}