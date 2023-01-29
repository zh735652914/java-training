package leetcode.programmerInterview;
/*
面试题 03.04. 化栈为队
实现一个MyQueue类，该类用两个栈来实现一个队列。


示例：

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // 返回 1
queue.pop();   // 返回 1
queue.empty(); // 返回 false

说明：

你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
通过次数3,668提交次数4,996
 */

import java.util.Stack;

//public class MyQueue {
//    /**
//     * Initialize your data structure here.
//     */
//    Stack<Integer> stackA;
//    Stack<Integer> stackB;
//
//    public MyQueue() {
//        stackA = new Stack<>();
//        stackB = new Stack<>();
//    }
//
//    /**
//     * Push element x to the back of queue.
//     */
//    public void push(int x) {
//        stackA.push(x);
//        int nums = stackB.size();
//        for (int i = 0; i < nums && !stackB.isEmpty(); i++) {
//            stackA.push(stackB.pop());
//        }
//        stackB.push(x);
//        for (int i = 0; i < nums; i++) {
//            stackB.push(stackA.pop());
//        }
//    }
//
//    /**
//     * Removes the element from in front of queue and returns that element.
//     */
//    public int pop() {
//        stackB.pop();
//        int nums = stackA.size();
//        for (int i = 0; i < nums - 1; i++) {
//            stackB.push(stackA.pop());
//        }
//        int ans = stackA.pop();
//        for (int i = 0; i < nums - 1; i++) {
//            stackA.push(stackB.pop());
//        }
//        return ans;
//    }
//
//    /**
//     * Get the front element.
//     */
//    public int peek() {
//        return stackB.peek();
//    }
//
//    /**
//     * Returns whether the queue is empty.
//     */
//    public boolean empty() {
//        return stackA.isEmpty();
//    }
//
//    public static void main(String[] args) {
//        MyQueue queue = new MyQueue();
//        queue.push(1);
//        queue.push(2);
//        System.out.println(queue.peek());// 返回 1
//        System.out.println(queue.pop());// 返回 1
//        System.out.println(queue.empty());// 返回 false
//    }
//}
public class MyQueue {

    /**
     * Initialize your data structure here.
     */
    Stack<Integer> writer;
    Stack<Integer> reader;

    public MyQueue() {
        writer = new Stack<>();
        reader = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        writer.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        peek();
        return reader.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!reader.isEmpty()) {
            return reader.peek();
        }
        while (!writer.isEmpty()) {
            reader.push(writer.pop());
        }
        return reader.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return reader.isEmpty() && writer.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());// 返回 1
        System.out.println(queue.pop());// 返回 1
        System.out.println(queue.empty());// 返回 false
    }
}