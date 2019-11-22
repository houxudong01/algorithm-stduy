package study.hash;

import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/5
 */
public class MyHashMapTest {

    @Test
    public void put() {
        MyHashMap<Character, String> map = new MyHashMap();

        for (int i = 65; i <= 90; i++) {
            Character i1 = (char) i;
            map.put(i1, "aa" + i);
        }

        System.out.println(map.get('A'));
        System.out.println(map.get('C'));
        System.out.println(map.get('R'));
        System.out.println(map.get('Z'));

        System.out.println(map.remove('A'));
        System.out.println(map.get('A'));
        System.out.println(map.get('Q'));

        System.out.println(map.remove('Z'));
        System.out.println(map.get('Z'));
    }
}
