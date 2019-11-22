package study.heap;

/**
 * 小顶堆实现
 * 用数组存储堆
 *
 * @author:hxd
 * @date:2019/11/10
 */
public class MinHeap {
    private int[] data;
    private int capacity;
    private int count;

    public MinHeap(int capacity) {
        data = new int[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    /**
     * 插入
     * 先插入最后一个位置，然后开始自下往上堆化
     *
     * @param value
     */
    public void insert(int value) {
        if (count > capacity) {
            return;
        }
        data[count] = value;
        int i = count;
        // 自下往上堆化
        // 数组 i 下标处节点的父节点下标为 (i - 1) / 2
        while ((i - 1) / 2 >= 0 && data[(i - 1) / 2] > data[i]) {
            swap(data, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
        count++;
    }

    /**
     * 移除堆顶元素
     */
    public int removeMin() {
        if (count == 0) {
            return -1;
        }
        // 直接把最后一个数据放到堆顶，然后开始重新堆化
        int minValue = data[0];
        data[0] = data[--count];
        heapIfy(data, count - 1, 0);
        return minValue;
    }

    /**
     * 自上往下堆化
     *
     * @param data
     * @param n
     * @param i
     */
    private void heapIfy(int[] data, int n, int i) {
        while (true) {
            int minPos = i;
            if (2 * i + 1 <= n && data[i] > data[2 * i + 1]) {
                minPos = 2 * i + 1;
            }

            if (2 * i + 2 <= n && data[minPos] > data[2 * i + 2]) {
                minPos = 2 * i + 2;
            }
            if (minPos == i) {
                return;
            }
            swap(data, i, minPos);
            i = minPos;
        }
    }

    /**
     * 交换数组中两个位置的值
     *
     * @param data
     * @param i
     * @param j
     */
    public void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
