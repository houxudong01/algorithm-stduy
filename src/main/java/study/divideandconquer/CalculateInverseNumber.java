package study.divideandconquer;

/**
 * 利用分治思想求一组数据的逆序对个数
 *
 * @author:hxd
 * @date:2019/11/16
 */
public class CalculateInverseNumber {
    /**
     * 逆序对个数
     */
    private int num = 0;

    public void cal(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) >> 1);
            cal(nums, start, mid);
            cal(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                // 此时需要注意：因为 [start,mid] 和 [mid+1,end] 内部已经是有序的了，
                // 所以可以确定当前 [start,mid] 之间比 a[j] 大的元素个数是 (mid - i +1)
                num = num + (mid - i + 1);
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= mid) {
            temp[k++] = nums[j++];
        }
        for (int x = 0; x < temp.length; x++) {
            nums[start + x] = temp[x];
        }
    }

}
