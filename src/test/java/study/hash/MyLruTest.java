package study.hash;

import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/6
 */
public class MyLruTest {

    @Test
    public void lruTest() {
        MyLru<Integer, String> lruCache = new MyLru();
        for (int i = 1; i <= 10; i++) {
            lruCache.put(i, "haha" + i);
        }
        System.out.println(lruCache);

        lruCache.put(11, "later" + 11);
        lruCache.put(11, "later" + 111);

        lruCache.get(5);
        lruCache.get(2);
        lruCache.get(8);

        lruCache.remove(3);

        System.out.println(lruCache);
    }
}
