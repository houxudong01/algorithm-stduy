package queue;

import org.junit.Before;
import org.junit.Test;
import queue.MyArrayQueue;

/**
 * @author:hxd
 * @date:2019/11/3
 */
public class MyArrayQueueTest {
    private MyArrayQueue myArrayQueue;

    @Before
    public void before() {
        myArrayQueue = new MyArrayQueue(5);
        for (int i = 1; i <= 5; i++) {
            myArrayQueue.put(i);
        }
    }

    @Test
    public void put() {
        System.out.println(myArrayQueue.take());
        System.out.println(myArrayQueue.take());
        System.out.println("size:" + myArrayQueue.size());
        myArrayQueue.put(6);
        System.out.println("size:" + myArrayQueue.size());
    }

    @Test
    public void take() {
        for (int i = 0; i < 5; i++) {
            System.out.println(myArrayQueue.take());
        }
        System.out.println(myArrayQueue.size());
    }
}
