package Beijing;
/*
https://leetcode-cn.com/problems/peeking-iterator/
 */

import java.util.Arrays;
import java.util.Iterator;

// 这题有点懵
public class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        nextElement = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer next = nextElement;
        nextElement = iterator.hasNext() ? iterator.next() : null;
        return next;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Iterator<Integer> iterator = Arrays.stream(nums).iterator();
        PeekingIterator peekingIterator = new PeekingIterator(iterator);
        System.out.println(peekingIterator.next());    // 返回 1 ，指针移动到下一个元素 [1,2,3]
        System.out.println(peekingIterator.peek());   // 返回 2 ，指针未发生移动 [1,2,3]
        System.out.println(peekingIterator.next());    // 返回 2 ，指针移动到下一个元素 [1,2,3]
        System.out.println(peekingIterator.next());    // 返回 3 ，指针移动到下一个元素 [1,2,3]
        System.out.println(peekingIterator.hasNext()); // 返回 False
    }
}
