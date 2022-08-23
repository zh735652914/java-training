package Beijing;
/*
https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */

// 的确要注意特例
public class removeNthNodeFromEndofList_19_topInterviewList {
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode faster = dummyHead, slower = dummyHead;
            while (n-- > 0) {
                faster = faster.next;
            }
            while (faster.next != null) {
                faster = faster.next;
                slower = slower.next;
            }
            slower.next = slower.next.next;
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2};
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
