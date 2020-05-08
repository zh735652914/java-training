package LeetCode.ProgrammerInterview;

import java.util.Stack;

/*
面试题 03.05. 栈排序
栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，
但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。

示例1:

 输入：
["SortedStack", "push", "push", "peek", "pop", "peek"]
[[], [1], [2], [], [], []]
 输出：
[null,null,null,1,null,2]
示例2:

 输入：
["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
[[], [], [], [1], [], []]
 输出：
[null,null,null,null,null,true]
说明:

栈中的元素数目在[0, 5000]范围内。 */
public class SortedStack {
    Stack<Integer> stack;
    Stack<Integer> help_stack;

    public SortedStack() {
        stack = new Stack<>();
        help_stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
        } else if (val > stack.peek()) {
            while (!stack.isEmpty() && val > stack.peek()) {
                help_stack.push(stack.pop());
            }
            stack.push(val);
        } else if (help_stack.isEmpty() || val >= help_stack.peek()) {
            help_stack.push(val);
        } else {
            while (!help_stack.isEmpty() && val < help_stack.peek()) {
                stack.push(help_stack.pop());
            }
            help_stack.push(val);
        }
    }

    public void pop() {
        peek();
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        while (!help_stack.isEmpty()) {
            stack.push(help_stack.pop());
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty() && help_stack.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack obj = new SortedStack();
        obj.pop();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        obj.pop();
        System.out.println(obj.peek());
    }
}
