//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.Arrays;

// 题目编号：88
// https://leetcode-cn.com/problems/merge-sorted-array/
@SuppressWarnings("all")
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] res = new int[m + n];
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    res[k++] = nums1[i++];
                } else {
                    res[k++] = nums2[j++];
                }
            }

            while (i < m) {
                res[k++] = nums1[i++];
            }

            while (j < n) {
                res[k++] = nums2[j++];
            }
            for (int x = 0; x < res.length; x++) {
                nums1[x] = res[x];
            }
        }

        public void merge2(int[] nums1, int m, int[] nums2, int n) {
            int j = 0;
            while (m < nums1.length) {
                nums1[m++] = nums2[j++];
            }
            Arrays.sort(nums1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}