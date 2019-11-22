package study.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/2
 */
public class AutoIncreaseCapacityListTest {
    AutoIncreaseCapacityList list;

    @Before
    public void before() {
        list = new AutoIncreaseCapacityList(5);
        // 事先加入 100 个元素
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
    }

    @Test
    public void add() {
        for (int i = 100; i < 200; i++) {
            list.add(i);
        }
        Assert.assertEquals(200, list.size());
    }

    @Test
    public void get() throws IllegalAccessException {
        Assert.assertEquals(88, list.get(88));
    }

    @Test
    public void remove() throws IllegalAccessException {
        Assert.assertEquals(88, list.remove(88));
    }

}
