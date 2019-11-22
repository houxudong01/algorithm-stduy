package study.stack;

/**
 * 使用数组实现一个栈
 *
 * @author:hxd
 * @date:2019/11/3
 */
public class MyArrayStack {
    private int[] data;
    private int capacity;
    private int size;

    public MyArrayStack(int capacity) {
        data = new int[capacity];
        this.capacity = capacity;
    }

    public Integer getStackTop() {
        if (size == 0) {
            return null;
        }
        return data[size - 1];
    }

    public Boolean push(int value) {
        if (size >= capacity) {
            return false;
        }
        data[size++] = value;
        return true;
    }

    public Integer pop() {
        if (size <= 0) {
            return null;
        }
        return data[--size];
    }
}
