package study.sort;

import java.util.Arrays;

/**
 * @author:hxd
 * @date:2019/11/4
 */
public class Sort {

    /**
     * 归并排序
     * 时间复杂度 O(nlogn)
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int[] mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int m = start + ((end - start) >> 1);
            mergeSort(nums, start, m);
            mergeSort(nums, m + 1, end);
            merge(nums, start, m, end);
        }
        return nums;

    }

    /**
     * 归并排序的合并步骤
     *
     * @param nums
     * @param start
     * @param mid
     * @param end
     */
    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= end) {
            temp[k++] = nums[j++];
        }

        for (int t = 0; t < temp.length; t++) {
            nums[start + t] = temp[t];
        }
    }

    /**
     * 快速排序
     * 时间复杂度 O(nlogn)
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int[] quickSort(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        int pivot = nums[i];

        if (i >= j) {
            return nums;
        }

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

        if (start < i - 1) {
            quickSort(nums, start, i - 1);
        }
        if (end > i + 1) {
            quickSort(nums, i + 1, end);
        }
        return nums;
    }

    /**
     * 选择排序
     * 平均时间复杂度 O(n^2)
     *
     * @param nums
     * @return
     */
    public static int[] selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(nums, i, minIndex);
            }
        }
        return nums;
    }

    /**
     * 冒泡排序
     * 平均时间复杂度 O(n^2)
     *
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    public static int[] swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
        return nums;
    }

    /**
     * 希尔排序
     * 时间复杂度 O(nlogn)
     *
     * @param nums
     * @return
     */
    public static int[] shellSort(int[] nums) {
        int len = nums.length;
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int cur = nums[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && nums[preIndex] > cur) {
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex -= gap;
                }
                nums[preIndex + gap] = cur;
            }
            gap /= 2;
        }
        return nums;
    }

    /**
     * 插入排序
     * 平均时间复杂度 O(n^2)
     *
     * @param nums
     * @return
     */
    public static int[] insertSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int preIndex = i;
            int current = nums[i + 1];
            while (preIndex >= 0 && current < nums[preIndex]) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = current;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 5, 3, 6, 4, 7};
        System.out.println("初始顺序：");
        System.out.println(Arrays.toString(nums));

        System.out.println("冒泡排序结果：");
        System.out.println(Arrays.toString(bubbleSort(nums)));

        System.out.println("选择排序结果：");
        nums = new int[]{4, 2, 5, 3, 6, 4, 7};
        System.out.println(Arrays.toString(selectSort(nums)));

        System.out.println("插入排序结果：");
        nums = new int[]{4, 2, 5, 3, 6, 4, 7};
        System.out.println(Arrays.toString(insertSort(nums)));

        System.out.println("希尔排序结果：");
        nums = new int[]{4, 2, 5, 3, 6, 4, 7};
        System.out.println(Arrays.toString(shellSort(nums)));

        System.out.println("快速排序结果：");
        nums = new int[]{4, 2, 5, 3, 6, 4, 7};
        System.out.println(Arrays.toString(quickSort(nums, 0, nums.length - 1)));

        System.out.println("归并排序结果：");
        nums = new int[]{4, 2, 5, 3, 6, 4, 7};
        System.out.println(Arrays.toString(mergeSort(nums, 0, nums.length - 1)));
    }
}
