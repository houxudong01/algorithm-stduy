package arrayandlinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/2
 */
public class SinglyLinkedListTest {
    private SinglyLinkedList singlyLinkedList;

    @Before
    public void before() {
        singlyLinkedList = new SinglyLinkedList();

        for (int i = 1; i <= 10; i++) {
            this.singlyLinkedList.add(i);
        }
    }

    @Test
    public void add() {
        SinglyLinkedList.ListNode node = this.singlyLinkedList.add(11);
    }

    @Test
    public void print() {
        this.singlyLinkedList.print();
    }

    @Test
    public void remove() {
        Boolean remove = this.singlyLinkedList.remove(5);
        Assert.assertTrue(remove);
    }
}
