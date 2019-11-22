package study.heap;

import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/10
 */
public class MaxHeapTest {

    @Test
    public void maxHeapTest() {
        MaxHeap maxHeap = new MaxHeap(15);
        for (int i = 2; i < 15; i++) {
            maxHeap.insert(i);
        }
        System.out.println(maxHeap);

        System.out.println(maxHeap.removeMax());
        System.out.println(maxHeap);
    }
}
