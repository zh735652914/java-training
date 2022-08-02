package Beijing;
/*
https://leetcode.cn/problems/design-circular-queue/
 */

// 记得只有一个节点的时候删除的情况
public class MyCircularQueue {
    class Node {
        int val;
        Node next;
        Node pre;

        Node(int val) {
            this.val = val;
        }
    }

    private int size;
    private final int k;
    private Node head;

    public MyCircularQueue(int k) {
        size = 0;
        this.k = k;
        head = null;
    }

    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        if (head == null) {
            head = new Node(value);
            head.next = head;
            head.pre = head;
        } else {
            Node tail = head.pre;
            head.pre = new Node(value);
            head.pre.pre = tail;
            head.pre.next = head;
            tail.next = head.pre;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        if (size == 1) {
            head = null;
            size = 0;
            return true;
        }
        Node newHead = head.next;
        head.next.pre = head.pre;
        head.pre.next = head.next;
        head = newHead;
        size--;
        return true;
    }

    public int Front() {
        return size == 0 ? -1 : head.val;
    }

    public int Rear() {
        return size == 0 ? -1 : head.pre.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.deQueue());  // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear());     // return 3
        System.out.println(myCircularQueue.isFull());   // return True
        System.out.println(myCircularQueue.deQueue());  // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear());     // return 4
        System.out.println(myCircularQueue.Front());
    }
}
