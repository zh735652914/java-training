package beijing;
/*
https://leetcode.cn/problems/design-circular-deque/
 */

// 细心写就行
public class MyCircularDeque {
    class Node {
        Node pre;
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    public int maxSize, size;
    Node head;

    public MyCircularDeque(int k) {
        maxSize = k;
        size = 0;
        head = new Node(-1);
        head.next = head;
        head.pre = head;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node next = head.next;
        head.next = new Node(value);
        head.next.next = next;
        head.next.pre = head;
        next.pre = head.next;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node pre = head.pre;
        head.pre = new Node(value);
        head.pre.pre = pre;
        head.pre.next = head;
        pre.next = head.pre;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        Node next = head.next.next;
        head.next = next;
        next.pre = head;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        Node pre = head.pre.pre;
        head.pre = pre;
        pre.next = head;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : head.next.val;
    }

    public int getRear() {
        return isEmpty() ? -1 : head.pre.val;
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));  // return True
        System.out.println(myCircularDeque.insertLast(2));  // return True
        System.out.println(myCircularDeque.insertFront(3)); // return True
        System.out.println(myCircularDeque.insertFront(4)); // return False, the queue is full.
        System.out.println(myCircularDeque.getRear());      // return 2
        System.out.println(myCircularDeque.isFull());       // return True
        System.out.println(myCircularDeque.deleteLast());   // return True
        System.out.println(myCircularDeque.insertFront(4));// return True
        System.out.println(myCircularDeque.getFront());     // return 4
    }
}
