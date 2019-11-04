package sort;

/**
 * 通过快排思想求无序数组中的第K大的元素
 *
 * @author:hxd
 * @date:2019/11/4
 */
public class TopkByQuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 1, 2, 7, 6, 6, 8, 5};
        int i = topK(nums, 0, nums.length - 1, 1);
        System.out.println(i);

    }


    public static int topK(int[] nums, int start, int end, int k) {
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
}
