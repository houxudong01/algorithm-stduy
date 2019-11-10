package heap;

import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/10
 */
public class MinHeapSortTest {

    @Test
    public void sort() {
        int[] nums = new int[]{7, 5, 19, 8, 14, 1, 20, 13, 16};
        MinHeapSort minHeapSort = new MinHeapSort();
        minHeapSort.sort(nums);
        System.out.println(minHeapSort);
    }
}
