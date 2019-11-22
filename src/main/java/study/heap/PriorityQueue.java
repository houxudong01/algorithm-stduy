package study.heap;

/**
 * 基于小顶堆实现一个优先级队列
 * 规定：整型值越小，优先级越高
 *
 * @author:hxd
 * @date:2019/11/14
 */
public class PriorityQueue {
    private int[] data;
    private int capacity;
    private int count;

    public PriorityQueue(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
    }

    /**
     * 入队
     *
     * @param value
     */
    public void add(int value) {
        if (count > capacity) {
            return;
        }
        data[count] = value;
        int i = count;
        while ((i - 1) / 2 >= 0 && data[(i - 1) / 2] > data[i]) {
            swap(data, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
        count++;
    }

    /**
     * 出队
     *
     * @return
     */
    public int poll() {
        if (count == 0) {
            return -1;
        }
        int reValue = data[0];
        data[0] = data[--count];
        heapIfy(data, count - 1, 0);
        return reValue;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean idEmpty() {
        return count == 0;
    }

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
