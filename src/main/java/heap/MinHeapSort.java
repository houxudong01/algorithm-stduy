package heap;

/**
 * 小顶堆实现堆排序
 * 最后结果按从大到小排列
 *
 * @author:hxd
 * @date:2019/11/10
 */
public class MinHeapSort {

    public void sort(int[] nums) {
        buildHeap(nums);
        int k = nums.length - 1;
        while (k > 1) {
            swap(nums, 0, k);
            k--;
            heapIfy(nums, k, 0);
        }
    }

    /**
     * 将无序数组组建成 小顶堆
     *
     * @param data
     */
    private void buildHeap(int[] data) {
        for (int i = data.length / 2; i >= 0; i--) {
            heapIfy(data, data.length - 1, i);
        }
    }

    /**
     * 将数据堆化
     *
     * @param data
     * @param n
     * @param i
     */
    private void heapIfy(int[] data, int n, int i) {
        while (true) {
            int minPos = i;
            if (2 * i + 1 <= n && data[2 * i + 1] < data[i]) {
                minPos = 2 * i + 1;
            }
            if (2 * i + 2 <= n && data[2 * i + 2] < data[minPos]) {
                minPos = 2 * i + 2;
            }
            if (minPos == i) {
                return;
            }
            swap(data, i, minPos);
            i = minPos;
        }
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
