package recursion;

import java.util.Arrays;

/**
 * @author:hxd
 * @date:2019/11/3
 */
public class RecursionDemo {

    public static void main(String[] args) {
        System.out.println(f(5));
        System.out.println(nFactorial(5));

        int[] array = new int[]{1, 2, 3};
        perm(array, 0, array.length-1);
    }

    /**
     * 斐波那契数列求和
     *
     * @param n
     * @return
     */
    public static int f(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }

    /**
     * 求 n！
     *
     * @param n
     */
    public static int nFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * nFactorial(n - 1);
    }

    /**
     * 实现一组数据的全排列
     * https://blog.csdn.net/weixin_42220532/article/details/90900815
     * https://blog.csdn.net/a754112602/article/details/81109663
     *
     * @param array
     * @param start
     * @param end
     */
    public static void perm(int[] array, int start, int end) {
        if (start == end) {
            System.out.println(Arrays.toString(array));
            return;
        }
        for (int i = start; i <= end; i++) {
            // 交换前缀，把第一个元素分别与后面的元素进行交换，递归的调用其子数组进行排序
            swap(array, start, i);
            perm(array, start + 1, end);
            // 将前缀交换回来，继续做上一个的前缀排列
            // 复原数组，为了保证下次另外的同级递归使用数组不会出错
            // 可以通过树来理解，每次回退一步操作，交换回去
            swap(array, start, i);
        }

    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
