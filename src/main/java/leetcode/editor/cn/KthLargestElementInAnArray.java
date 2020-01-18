//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

// 题目编号：215
// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
@SuppressWarnings("all")
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findKthLargest2(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }

        public int findKthLargest3(int[] nums, int k) {
            PriorityQueue<Integer> heapQueue = new PriorityQueue<>();
            for (int num : nums) {
                heapQueue.add(num);
                if (heapQueue.size() > k) {
                    heapQueue.poll();
                }
            }
            return heapQueue.peek();
        }

        public int findKthLargest4(int[] nums, int k) {
            return this.topK(nums, 0, nums.length - 1, k);
        }

        public int topK(int[] nums, int start, int end, int k) {
            int i = start;
            int j = end;
            int pivot = nums[i];
            if (i <= j) {
                while (i < j) {
                    while (nums[j] >= pivot && i < j) {
                        j--;
                    }
                    nums[i] = nums[j];

                    while (nums[i] <= pivot && i < j) {
                        i++;
                    }
                    nums[j] = nums[i];
                }
                nums[i] = pivot;

                // (nums.length -i)就是从右往左数i的位置
                if (k == nums.length - i) {
                    return nums[i];
                }
                if (k < nums.length - i) {
                    return topK(nums, i + 1, end, k);
                }
                if (k > nums.length - i) {
                    return topK(nums, start, i - 1, k);
                }
            }
            return -1;
        }

        public int findKthLargest(int[] nums, int k) {
            buildHeap(nums, k);
            for (int i = k; i < nums.length; i++) {
                if (nums[i] > nums[0]) {
                    nums[0] = nums[i];
                    heapIfy(nums, 0, k);
                }
            }
            return nums[0];
        }

        private void buildHeap(int[] nums, int k) {
            for (int i = (k - 1) / 2; i >= 0; i--) {
                heapIfy(nums, i, k);
            }
        }

        private void heapIfy(int[] nums, int i, int n) {
            while (true) {
                int minPos = i;
                if (2 * i + 1 < n && nums[2 * i + 1] < nums[i]) {
                    minPos = 2 * i + 1;
                }
                if (2 * i + 2 < n && nums[2 * i + 2] < nums[minPos]) {
                    minPos = 2 * i + 2;
                }
                if (minPos == i) {
                    break;
                }
                swap(nums, i, minPos);
                i = minPos;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}