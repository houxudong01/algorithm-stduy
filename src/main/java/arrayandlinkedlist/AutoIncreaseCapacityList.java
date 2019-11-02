package arrayandlinkedlist;

import java.util.Arrays;

/**
 * 简单实现自动扩容和缩容的数组
 *
 * @author: hxd
 * @date: 2019/11/02
 */
public class AutoIncreaseCapacityList {
    private int[] elementData;
    private int size = 0;

    public AutoIncreaseCapacityList(int capacity) {
        this.elementData = new int[capacity];
    }

    public int size() {
        return size;
    }

    public void add(int element) {
        if (size > elementData.length - 1) {
            elementData = Arrays.copyOf(elementData, elementData.length << 1);
        }
        elementData[size++] = element;
    }

    public int get(int index) throws IllegalAccessException {
        if (index < 0 || index >= elementData.length) {
            throw new IllegalAccessException("Index illegal!");
        }
        return elementData[index];
    }

    public int remove(int index) throws IllegalAccessException {
        if (index < 0 || index >= elementData.length) {
            throw new IllegalAccessException("Index illegal!");
        }
        int oldElement = elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = numMoved;
        return oldElement;
    }

}
