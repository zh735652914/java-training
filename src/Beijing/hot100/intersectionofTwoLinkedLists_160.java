package Beijing.hot100;
/*
https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */

import java.util.HashSet;
import java.util.Set;

public class intersectionofTwoLinkedLists_160 {
    // 官方解析的答案，自己还是没想到
    static public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p = headA, q = headB;
            while (p != q) {
                p = p != null ? p.next : headB;
                q = q != null ? q.next : headA;
            }
            return p;
        }
    }

    // 自己用的set，很简单
    static public class Solution0 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> visited = new HashSet<>();
            ListNode p = headA;
            while (p != null) {
                visited.add(p);
                p = p.next;
            }
            p = headB;
            while (p != null && !visited.contains(p)) {
                p = p.next;
            }
            return p;
        }
    }

    public static void main(String[] args) {
        int intersectVal = 8;
        int[] nodesA = {4, 1, 8, 4, 5}, nodesB = {5, 6, 1, 8, 4, 5};
        int skipA = 2, skipB = 3;
        ListNode dummyHeadA = new ListNode(-1);
        ListNode dummyHeadB = new ListNode(-1);
        ListNode p = dummyHeadA;
        ListNode intersect = new ListNode();
        for (int i = 0; i < nodesA.length; i++) {
            p.next = new ListNode(nodesA[i]);
            if (i == skipA) {
                intersect = p.next;
            }
            p = p.next;
        }
        p = dummyHeadB;
        for (int i = 0; i < skipB; i++) {
            p.next = new ListNode(nodesB[i]);
            p = p.next;
        }
        p.next = intersect;
        System.out.println(new Solution().getIntersectionNode(dummyHeadA.next, dummyHeadB.next).val);
    }
}
