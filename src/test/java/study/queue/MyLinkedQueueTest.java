package study.queue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/3
 */
public class MyLinkedQueueTest {
    private MyLinkedQueue myLinkedQueue;

    @Before
    public void before() {
        myLinkedQueue = new MyLinkedQueue();
        for (int i = 1; i <= 5; i++) {
            myLinkedQueue.put(i);
        }
    }

    @Test
    public void put() {
        for (int i = 6; i <= 10; i++) {
            myLinkedQueue.put(i);
        }
    }

    @Test
    public void take() {
        int size = myLinkedQueue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(myLinkedQueue.take());
        }
        System.out.println(myLinkedQueue.take());
    }
}
