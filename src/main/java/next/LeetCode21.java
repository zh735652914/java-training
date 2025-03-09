package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/9 14:06
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 */
public class LeetCode21 {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode perHead = new ListNode(-1);
        ListNode p = list1, q = list2;
        ListNode cur = perHead;
        while (p != null && q != null) {
            if (p.val < q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }
        if (p != null) {
            cur.next = p;
        }
        if (q != null) {
            cur.next = q;
        }
        return perHead.next;
    }

    @Test
    public void test() {
        int[] nodes1 = {1, 2, 4};
        int[] nodes2 = {1, 3, 4};
        ListNode list1 = buildList(nodes1);
        ListNode list2 = buildList(nodes2);
        ListNode ans = mergeTwoLists(list1, list2);
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
