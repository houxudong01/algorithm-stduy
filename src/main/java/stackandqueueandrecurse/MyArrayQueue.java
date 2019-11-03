package stackandqueueandrecurse;

/**
 * 有界数组队列
 *
 * @author:hxd
 * @date:2019/11/3
 */
public class MyArrayQueue {
    private int[] data;
    private int takeIndex;
    private int putIndex;
    private int size;

    public MyArrayQueue(int capacity) {
        this.data = new int[capacity];
    }

    public int size() {
        return size;
    }

    public Boolean put(int value) {
        if (putIndex == data.length) {
            // 如果 putIndex 超出范围，但是 takeIndex 之前有空位，那么就进行数据前移
            if (takeIndex != 0) {
                for (int i = takeIndex; i < putIndex; i++) {
                    data[i - takeIndex] = data[i];
                }
                putIndex = putIndex - takeIndex;
                takeIndex = 0;
            } else {
                return false;
            }

        }
        data[putIndex++] = value;
        size++;
        return true;
    }

    public Integer take() {
        if (takeIndex == putIndex) {
            return null;
        }
        int value = data[takeIndex++];
        size--;
        return value;
    }
}
