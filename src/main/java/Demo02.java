import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author:hxd
 * @date:2020/9/20
 */
public class Demo02 {
    private static volatile int i = 0;
    private static volatile int flag = 0;

    public static void main(String[] args) {
//        Thread t1 = new Thread(new R1(), "1");
//        Thread t2 = new Thread(new R2(), "2");
//
//        t1.start();
//        t2.start();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List clone = (List) list.clone();
        System.out.println(clone);
    }

    static class R1 implements Runnable {

        @Override
        public void run() {
            while (i < 10) {

                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + " -- " + i);
                    i++;
                }

            }
        }
    }

    static class R2 implements Runnable {

        @Override
        public void run() {
            while (i < 10) {
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + " -- " + i);
                    i++;
                }
            }
        }
    }

}
