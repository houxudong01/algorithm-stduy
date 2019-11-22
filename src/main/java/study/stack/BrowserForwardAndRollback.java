package study.stack;

/**
 * 浏览器页面前进后退功能模拟
 *
 * @author:hxd
 * @date:2019/11/3
 */
public class BrowserForwardAndRollback {

    private MyArrayStack mainStack = new MyArrayStack(5);
    private MyArrayStack minorStack = new MyArrayStack(5);

    /**
     * 访问新页面
     *
     * @param pageId 页面 id
     */
    public void access(int pageId) {
        mainStack.push(pageId);
    }

    /**
     * 后退页面
     *
     * @return
     */
    public Integer rollback() {
        Integer pop = mainStack.pop();
        if (pop == null) {
            return null;
        }
        minorStack.push(pop);
        return mainStack.getStackTop();
    }

    /**
     * 前进页面
     *
     * @return
     */
    public Integer forward() {
        Integer pop = minorStack.pop();
        if (pop == null) {
            return null;
        }
        mainStack.push(pop);
        return pop;
    }

}
