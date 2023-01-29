package leetcode;

/*
logo
探索
题库
圈子
竞赛
企业
商店


题目描述
评论 (27)
题解(34)
提交记录
面试题 17.20. 连续中值
随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。

中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例：

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2
通过次数1,702提交次数3,064
 */


import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (minHeap.size() > maxHeap.size()) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
        }
        return minHeap.size() < maxHeap.size() ? maxHeap.peek() : minHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(-1);
        obj.addNum(-2);
        System.out.println(obj.findMedian()); // -> 1.5
        obj.addNum(-3);
        obj.addNum(-4);
        obj.addNum(-5);
        System.out.println(obj.findMedian()); // -> 2
    }
}
