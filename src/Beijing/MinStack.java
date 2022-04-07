package Beijing;
/*
https://leetcode-cn.com/problems/min-stack/
 */

import java.util.Stack;

// 要是不让使用辅助栈就不太好写了，考虑使用差值或者链表
public class MinStack {
    private final Stack<Integer> stack;
    private int MIN;

    public MinStack() {
        stack = new Stack<>();
        MIN = 0;
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            MIN = val;
        } else {
            MIN = Math.min(MIN, val);
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.peek() == MIN) {
            stack.pop();
            MIN = Integer.MAX_VALUE;
            Stack<Integer> tmp = new Stack<>();
            while (!stack.isEmpty()) {
                MIN = Math.min(MIN, stack.peek());
                tmp.push(stack.pop());
            }
            while (!tmp.isEmpty()) {
                stack.push(tmp.pop());
            }
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return MIN;
    }

    public static void main(String[] args) {
        String[] ops = {"MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"};
        int[][] nums = {{}, {-2}, {0}, {-3}, {}, {}, {}, {}};
        MinStack minStack = new MinStack();
        for (int i = 1; i < ops.length; i++) {
            switch (ops[i]) {
                case "push":
                    minStack.push(nums[i][0]);
                    break;
                case "getMin":
                    System.out.println(minStack.getMin());
                    break;
                case "pop":
                    minStack.pop();
                    break;
                case "top":
                    System.out.println(minStack.top());
                    break;
            }
        }
    }
}
