package Beijing;
/*
https://leetcode.cn/problems/sort-list/
 */

public class sortList_148_topInterviewList {
    // 第四次写了，自己的思路一开始不够明确
    static class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            if (head.next.next == null) {
                ListNode headB = head.next;
                head.next = null;
                return mergeList(head, headB);
            }
            ListNode faster = head, slower = head;
            while (faster != null && faster.next != null) {
                faster = faster.next.next;
                slower = slower.next;
            }
            ListNode headB = slower.next;
            slower.next = null;
            return mergeList(sortList(head), sortList(headB));
        }

        private ListNode mergeList(ListNode headA, ListNode headB) {
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
            while (headA != null && headB != null) {
                if (headA.val < headB.val) {
                    p.next = headA;
                    headA = headA.next;
                } else {
                    p.next = headB;
                    headB = headB.next;
                }
                p = p.next;
            }
            if (headA != null) {
                p.next = headA;
            }
            if (headB != null) {
                p.next = headB;
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {4, 2, 1, 3};
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        ListNode ans = new Solution().sortList(dummyHead.next);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
