package stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stack.MyArrayStack;

/**
 * @author:hxd
 * @date:2019/11/3
 */
public class MyArrayStackTest {

    private MyArrayStack myArrayStack;

    @Before
    public void before() {
        myArrayStack = new MyArrayStack(5);
    }

    @Test
    public void push() {
        for (int i = 1; i <= 5; i++) {
            Boolean push = myArrayStack.push(i);
            Assert.assertTrue(push);
        }
        Boolean push = myArrayStack.push(6);
        Assert.assertFalse(push);

        for (int i = 0; i < 7; i++) {
            System.out.println(myArrayStack.pop());
        }
    }
}
