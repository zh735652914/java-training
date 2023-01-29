package beijing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 自己写的，需要看看这个接口写法
public class flattenNestedListIterator {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    static public class NestedIterator implements Iterator<Integer> {

        private final Queue<Integer> queue;

        public NestedIterator(List<NestedInteger> nestedList) {
            queue = new LinkedList<>();
            for (NestedInteger atom : nestedList) {
                inputQueue(atom);
            }
        }

        @Override
        public Integer next() {
            return queue.poll();
        }

        private void inputQueue(NestedInteger nestedInteger) {
            if (nestedInteger == null) {
                return;
            }
            if (nestedInteger.isInteger()) {
                queue.offer(nestedInteger.getInteger());
                return;
            }
            for (NestedInteger atom : nestedInteger.getList()) {
                inputQueue(atom);
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        // nestedList = [[1,1],2,[1,1]]
        List<NestedInteger> nestedList = new ArrayList<>();
//        nestedList.add();
        NestedIterator i = new NestedIterator(nestedList);
    }
}