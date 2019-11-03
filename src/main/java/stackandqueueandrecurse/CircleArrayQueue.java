package stackandqueueandrecurse;

/**
 * 循环队列
 *
 * @author:hxd
 * @date:2019/11/3
 */
public class CircleArrayQueue {
    private int[] data;
    private int capacity;
    private int putIndex;
    private int takeIndex;
    private int size;

    public CircleArrayQueue(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
    }

    public int size() {
        return size;
    }

    public Boolean put(int value) {
        if ((putIndex + 1) % capacity == takeIndex) {
            return false;
        }
        data[putIndex] = value;
        putIndex = (putIndex + 1) % capacity;
        size++;
        return true;
    }

    public Integer take() {
        if (takeIndex == putIndex) {
            return null;
        }
        int value = data[takeIndex];
        takeIndex = (takeIndex + 1) % capacity;
        size--;
        return value;
    }

}
