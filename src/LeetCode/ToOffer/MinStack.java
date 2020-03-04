package LeetCode.ToOffer;
/*
面试题30. 包含min函数的栈
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。



示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.


提示：

各函数的调用总次数不超过 20000 次


注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/

通过次数2,908提交次数4,908
 */

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {

    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        if (stack.peek().equals(min.peek())) {
            stack.pop();
            min.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.min());   //返回 -1024.
        minStack.pop();
        System.out.println(minStack.min());   //返回 -1024.
        minStack.pop();
        System.out.println(minStack.min());   //返回 -512

    }
}
