package queue;

import org.junit.Before;
import org.junit.Test;
import queue.CircleArrayQueue;

/**
 * @author:hxd
 * @date:2019/11/3
 */
public class CircleArrayQueueTest {
    private CircleArrayQueue circleArrayQueue;

    @Before
    public void before() {
        circleArrayQueue = new CircleArrayQueue(6);
    }

    @Test
    public void put() {
        for (int i = 1; i < 6; i++) {
            circleArrayQueue.put(i);
        }
        System.out.println("size:" + circleArrayQueue.size());

        System.out.println(circleArrayQueue.take());
        System.out.println(circleArrayQueue.take());
        System.out.println("size:" + circleArrayQueue.size());

        circleArrayQueue.put(6);
        circleArrayQueue.put(7);
        System.out.println("size:" + circleArrayQueue.size());

        circleArrayQueue.put(8);
        System.out.println("size:" + circleArrayQueue.size());
    }
}
