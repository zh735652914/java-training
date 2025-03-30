package next;

import next.utils.ListNode;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/3/30 16:02
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 */
public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }

    @Test
    public void test() {
        int[] listA = {4, 1, 8, 4, 5}, listB = {5, 6, 1, 8, 4, 5};
        int skipA = 2, skipB = 3;
        ListNode headA = buildList(listA);
        ListNode interNode = headA;
        for (int i = 0; i <= skipA; i++) {
            interNode = interNode.next;
        }
        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;
        for (int i = 0; i <= skipB; i++) {
            p.next = new ListNode(listB[i]);
            p = p.next;
        }
        p.next = interNode;
        assertEquals(interNode, getIntersectionNode(headA, preHead.next));
    }

    private ListNode buildList(int[] nodes) {
        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        return preHead.next;
    }
}
