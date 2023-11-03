package leetcode.tooffer;
/*
面试题59 - II. 队列的最大值
请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1

示例 1：

输入:
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
示例 2：

输入:
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]


限制：

1 <= push_back,pop_front,max_value的总操作数 <= 10000
1 <= value <= 10^5
通过次数15,717提交次数31,961
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
/*
面试题59 - II. 队列的最大值
请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1

示例 1：

输入:
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
示例 2：

输入:
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]


限制：

1 <= push_back,pop_front,max_value的总操作数 <= 10000
1 <= value <= 10^5
通过次数15,717提交次数31,961
 */

//自己没想到用双端队列，看了解答才知道。。。
public class MaxQueue {
    Deque<Integer> deque;
    Queue<Integer> queue;

    public MaxQueue() {
        deque = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        return deque.size() > 0 ? deque.peek() : -1;
    }

    public void push_back(int value) {
        queue.offer(value);
        while (deque.size() > 0 && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        int Pop = queue.size() > 0 ? queue.poll() : -1;
        if (deque.size() > 0 && Pop == deque.peekFirst()) {
            deque.pollFirst();
        }
        return Pop;
    }

    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
//        obj.push_back(1);
//        obj.push_back(2);
//        System.out.println(obj.max_value());//2
//        System.out.println(obj.pop_front());//1
//        System.out.println(obj.max_value());//2
        System.out.println(obj.pop_front());
        System.out.println(obj.max_value());
    }
}
/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
