package list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/3
 */
public class CircleLinkedListTest {
    private CircleLinkedList circleLinkedList;

    @Before
    public void before() {
        circleLinkedList = new CircleLinkedList();
        for (int i = 1; i <= 5; i++) {
            this.circleLinkedList.add(i);
        }
    }

    @Test
    public void add() {
        this.circleLinkedList.add(6);
    }

    @Test
    public void remove() {
        Boolean remove = this.circleLinkedList.remove(1);
        Assert.assertTrue(remove);
    }

}
