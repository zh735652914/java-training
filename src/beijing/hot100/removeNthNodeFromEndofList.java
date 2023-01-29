package beijing.hot100;
/*
https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */

// 不难，注意特殊情况就行
public class removeNthNodeFromEndofList {
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode faster = head, slower = head;
            for (int i = 0; i < n; i++) {
                faster = faster.next;
            }
            while (faster != null) {
                faster = faster.next;
                slower = slower.next;
            }
            ListNode dummyhead = new ListNode(-1);
            dummyhead.next = head;
            ListNode pre = dummyhead;
            while (pre.next != slower) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
            return dummyhead.next;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5};
        int n = 1;
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        ListNode ans = new Solution().removeNthFromEnd(dummyHead.next, n);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
