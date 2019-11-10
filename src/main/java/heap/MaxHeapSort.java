package heap;

/**
 * 大顶堆实现堆排序
 * 最后结果按从小到大排列
 *
 * @author:hxd
 * @date:2019/11/10
 */
public class MaxHeapSort {

    public void sort(int[] nums) {
        buildHeap(nums);
        int k = nums.length - 1;
        while (k > 0) {
            swap(nums, 0, k);
            k--;
            heapIfy(nums, k, 0);
        }
    }

    /**
     * 将无序数组组建成 大顶堆
     *
     * @param nums
     */
    private void buildHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            heapIfy(nums, nums.length - 1, i);
        }
    }

    private void heapIfy(int[] data, int n, int i) {
        while (true) {
            int maxPos = i;
            if (2 * i + 1 <= n && data[2 * i + 1] > data[i]) {
                maxPos = 2 * i + 1;
            }
            if (2 * i + 2 <= n && data[2 * i + 2] > data[maxPos]) {
                maxPos = 2 * i + 2;
            }
            if (maxPos == i) {
                return;
            }
            swap(data, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
