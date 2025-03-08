package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/8 09:52
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class LeetCode19 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode faster = preHead;
        ListNode slower = preHead;
        for (int i = 0; i < n && faster != null; i++) {
            faster = faster.next;
        }
        while (slower != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next;
        }
        slower.next = slower.next.next;
        return preHead.next;
    }

    @Test
    public void test() {
        int[] nodes = {1, 2, 3, 4, 5};
        int n = 5;
        ListNode head = buildList(nodes);
        ListNode ans = removeNthFromEnd(head, n);
        printList(ans);
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
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
