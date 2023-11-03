package beijing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhouhao
 * @date 2023/1/6 13:01
 */
// 不难，写起来不顺手而已
public class FlattenNestedListIterator_341_topInterviewList {
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
            for (NestedInteger nestedInteger : nestedList) {
                addAtom(nestedInteger);
            }
        }

        private void addAtom(NestedInteger nestedList) {
            if (nestedList == null) {
                return;
            }
            if (!nestedList.isInteger()) {
                for (NestedInteger nestedInteger : nestedList.getList()) {
                    addAtom(nestedInteger);
                }
            } else {
                queue.offer(nestedList.getInteger());
            }
        }

        @Override
        public Integer next() {
            return queue.poll();
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
