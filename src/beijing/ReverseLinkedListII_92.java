package beijing;
/*
https://leetcode.cn/problems/reverse-linked-list-ii/
 */

/**
 * @author zhouhao
 * @date 2023/10/15 13:00
 */
public class ReverseLinkedListII_92 {
    static class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode per = dummyHead;
            for (int i = 0; i < left - 1; i++) {
                per = per.next;
            }
            ListNode start = per.next;
            ListNode p = start;
            for (int i = left; i < right; i++) {
                p = p.next;
            }
            ListNode next = p.next;
            p.next = null;
            per.next = reverseList(start);
            start.next = next;
            return dummyHead.next;
        }

        // 反转链表
        private ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return next;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5};
        int left = 2, right = 4;
        ListNode head = mkList(nodes);
        ListNode ans = new Solution().reverseBetween(head, left, right);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }

    private static ListNode mkList(int[] nodes) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        return dummyHead.next;
    }
}
