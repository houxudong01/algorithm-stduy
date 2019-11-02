package arrayandlinkedlist;

import java.util.Arrays;

/**
 * 合并两个有序数组为一个有序数组
 *
 * @author:hxd
 * @date:2019/11/2
 */
public class MergeTwoSortedArray {

    public static int[] merge(int[] array1, int[] array2) {
        int[] temp = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;
        while ((i <= array1.length - 1) && (j <= array2.length - 1)) {
            if (array1[i] < array2[j]) {
                temp[k++] = array1[i++];
            } else {
                temp[k++] = array2[j++];
            }
        }

        if (i < array1.length) {
            for (int t = i; t < array1.length; t++) {
                temp[k++] = array1[t];
            }
        }

        if (j < array2.length) {
            for (int t = j; t < array2.length; t++) {
                temp[k++] = array2[t];
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 3, 4, 5, 7, 9, 20};
        int[] array2 = new int[]{2, 3, 4, 6, 8, 8, 10, 12, 14};
        int[] mergeArray = merge(array1, array2);
        System.out.println(Arrays.toString(mergeArray));
    }
}
