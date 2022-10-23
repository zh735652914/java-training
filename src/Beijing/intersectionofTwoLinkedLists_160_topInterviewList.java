package Beijing;
/*
https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */

public class intersectionofTwoLinkedLists_160_topInterviewList {
    // 自己还是没写出来
    static public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p = headA, q = headB;
            while (p != q) {
                p = p == null ? headB : p.next;
                q = q == null ? headA : q.next;
            }
            return p;
        }
    }

    public static void main(String[] args) {
        ListNode listA = mkList(new int[]{4, 1, 8, 4, 5});
        ListNode listB = mkList(new int[]{5, 6, 1, 8, 4, 5});
        int intersectVal = 8, skipA = 2, skipB = 3;
        ListNode pos = listA;
        for (int i = 0; i < skipA; i++) {
            pos = pos.next;
        }
        ListNode B = listB;
        for (int i = 0; i < skipB - 1; i++) {
            B = B.next;
        }
        B.next = pos;
        ListNode ans = new Solution().getIntersectionNode(listA, listB);
        System.out.println(ans != null ? ans.val : "null");
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
