package beijing.hot100;
/*
https://leetcode.cn/problems/min-stack/
 */

import java.util.Stack;

// 怎么感觉自己第二次写的不太好
public class minStack_155 {
    static class MinStack {
        private final Stack<Integer> minS;
        private final Stack<Integer> stack;

        public MinStack() {
            stack = new Stack<>();
            minS = new Stack<>();
        }

        public void push(int val) {
            if (minS.isEmpty() || minS.peek() >= val) {
                minS.push(val);
            }
            stack.push(val);
        }

        public void pop() {
            int val = stack.pop();
            if (minS.peek() == val) {
                minS.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minS.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        String[] ops = {"push", "push", "push", "getMin", "pop", "top", "getMin"};
        int[] nums = {-2, 0, -3, 0, 0, 0, 0};
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "push":
                    minStack.push(nums[i]);
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
