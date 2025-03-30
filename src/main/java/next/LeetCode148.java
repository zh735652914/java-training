package next;

import next.utils.ListNode;
import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/30 10:52
 * https://leetcode.cn/problems/sort-list/
 */
public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode faster = head.next;
        ListNode slower = head;
        while (faster != null && faster.next != null && slower != null) {
            faster = faster.next.next;
            slower = slower.next;
        }
        ListNode A = head, B = slower.next;
        slower.next = null;
        return merge(sortList(A), sortList(B));
    }

    private ListNode merge(ListNode A, ListNode B) {
        if (A == null || B == null) {
            return A == null ? B : A;
        }
        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;
        while (A != null && B != null) {
            if (A.val <= B.val) {
                p.next = A;
                A = A.next;
            } else {
                p.next = B;
                B = B.next;
            }
            p = p.next;
        }
        if (A != null) {
            p.next = A;
        }
        if (B != null) {
            p.next = B;
        }
        return preHead.next;
    }

    @Test
    public void test() {
        int[] nodes = {4, 2, 1, 3};
        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        ListNode ans = sortList(preHead.next);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
