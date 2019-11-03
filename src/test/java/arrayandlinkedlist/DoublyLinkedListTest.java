package arrayandlinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/3
 */
public class DoublyLinkedListTest {
    private DoublyLinkedList doublyLinkedList;

    @Before
    public void before() {
        doublyLinkedList = new DoublyLinkedList();
        for (int i = 1; i <= 5; i++) {
            doublyLinkedList.add(i);
        }
    }

    @Test
    public void add() {
        doublyLinkedList.add(8);
    }

    @Test
    public void print() {
        this.doublyLinkedList.print();
    }

    @Test
    public void remove() {
        Boolean remove = this.doublyLinkedList.remove(3);
        Assert.assertTrue(remove);
    }
}
