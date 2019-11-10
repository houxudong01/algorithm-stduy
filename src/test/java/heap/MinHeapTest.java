package heap;

import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/10
 */
public class MinHeapTest {

    @Test
    public void minHeapTest() {
        MinHeap minHeap = new MinHeap(15);
        for (int i = 15; i > 2; i--) {
            minHeap.insert(i);
        }
        System.out.println(minHeap);
        minHeap.removeMin();
        System.out.println(minHeap);

        minHeap.removeMin();
        System.out.println(minHeap);

        minHeap.removeMin();
        System.out.println(minHeap);
    }
}
