//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) -- 将元素 x 推入栈中。 
// pop() -- 删除栈顶的元素。 
// top() -- 获取栈顶元素。 
// getMin() -- 检索栈中的最小元素。 
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
// Related Topics 栈 设计

package leetcode.editor.cn;

import java.util.Stack;

// 题目编号：155
// https://leetcode-cn.com/problems/min-stack/
@SuppressWarnings("all")
public class MinStack {
    public static void main(String[] args) {
        MyMinStack solution = new MyMinStack();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    static class MyMinStack {
        private Stack<Integer> mainStack;
        private Stack<Integer> minStack;
        private int min;

        /**
         * initialize your data structure here.
         */
        public MyMinStack() {
            mainStack = new Stack<>();
            minStack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            mainStack.push(x);
            min = Math.min(min, x);
            minStack.push(min);
        }

        public void pop() {
            mainStack.pop();
            minStack.pop();
            min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }

        public int top() {
            return mainStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)


}