package heap;

/**
 * 大顶堆实现
 *
 * @author:hxd
 * @date:2019/11/10
 */
public class MaxHeap {
    private int[] data;
    private int capacity;
    private int count;

    public MaxHeap(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    /**
     * 插入
     *
     * @param value
     */
    public void insert(int value) {
        if (count > capacity) {
            return;
        }
        data[count] = value;

        int i = count;
        while (i / 2 >= 0 && data[i] > data[i / 2]) {
            swap(data, i, i / 2);
            i = i / 2;
        }
        count++;
    }

    /**
     * 移除堆顶元素
     */
    public int removeMax() {
        if (count == 0) {
            return -1;
        }
        int maxValue = data[0];
        data[0] = data[--count];
        heapIfy(data, count, 0);
        return maxValue;
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
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
            swap(data, maxPos, i);
            i = maxPos;
        }
    }
}
