package stack;

import org.junit.Before;
import org.junit.Test;
import stack.BrowserForwardAndRollback;

/**
 * @author:hxd
 * @date:2019/11/3
 */
public class BrowserForwardAndRollbackTest {
    private BrowserForwardAndRollback browserForwardAndRollback;

    @Before
    public void before() {
        browserForwardAndRollback = new BrowserForwardAndRollback();
    }

    @Test
    public void access() {
        // 一次访问了四个页面，当前处在 page4
        browserForwardAndRollback.access(1);
        browserForwardAndRollback.access(2);
        browserForwardAndRollback.access(3);
        browserForwardAndRollback.access(4);

        // 向后回退页面，退回到 page1
        System.out.println(browserForwardAndRollback.rollback());
        System.out.println(browserForwardAndRollback.rollback());
        System.out.println(browserForwardAndRollback.rollback());

        // 前进页面，前进到 page4
        System.out.println(browserForwardAndRollback.forward());
        System.out.println(browserForwardAndRollback.forward());
        System.out.println(browserForwardAndRollback.forward());
    }
}
