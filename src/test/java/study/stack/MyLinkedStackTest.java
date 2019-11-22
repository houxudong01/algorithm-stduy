package study.stack;

import org.junit.Before;
import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/3
 */
public class MyLinkedStackTest {
    private MyLinkedStack myLinkedStack;

    @Before
    public void before() {
        myLinkedStack = new MyLinkedStack();
    }

    @Test
    public void push() {
        for (int i = 1; i <= 5; i++) {
            myLinkedStack.push(i);
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println(myLinkedStack.pop());
        }
    }
}
