package heap;

import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/10
 */
public class MaxHeapSortTest {

    @Test
    public void maxHeapSort() {
        int[] nums = new int[]{7, 5, 19, 8, 14, 1, 20, 13, 16};
        MaxHeapSort maxHeapSort = new MaxHeapSort();
        maxHeapSort.sort(nums);
        System.out.println(nums);
    }
}
