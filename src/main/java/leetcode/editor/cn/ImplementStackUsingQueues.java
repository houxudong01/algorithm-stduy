//使用队列实现栈的下列操作： 
//
// 
// push(x) -- 元素 x 入栈 
// pop() -- 移除栈顶元素 
// top() -- 获取栈顶元素 
// empty() -- 返回栈是否为空 
// 
//
// 注意: 
//
// 
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。 
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。 
// 
// Related Topics 栈 设计

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// 题目编号：225
// https://leetcode-cn.com/problems/implement-stack-using-queues/
@SuppressWarnings("all")
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack solution = new MyStack();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(4);

        System.out.println(solution.top());

        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    static class MyStack {
        private Deque<Integer> deQueue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            deQueue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            deQueue.addFirst(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return deQueue.removeFirst();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return deQueue.peekFirst();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return deQueue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)


}