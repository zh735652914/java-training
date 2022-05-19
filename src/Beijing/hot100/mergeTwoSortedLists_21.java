package Beijing.hot100;
/*
https://leetcode.cn/problems/merge-two-sorted-lists/
 */

// 这题也很简单
public class mergeTwoSortedLists_21 {
    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummyhead = new ListNode(-1);
            ListNode p = dummyhead;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    p.next = list1;
                    list1 = list1.next;
                } else {
                    p.next = list2;
                    list2 = list2.next;
                }
                p = p.next;
            }
            p.next = list1 != null ? list1 : list2;
            return dummyhead.next;
        }
    }

    public static void main(String[] args) {
        int[] nodes1 = {1, 2, 4};
        int[] nodes2 = {1, 3, 4};
        ListNode dummy1 = new ListNode(-1);
        ListNode p = dummy1;
        for (int node : nodes1) {
            p.next = new ListNode(node);
            p = p.next;
        }
        ListNode dummy2 = new ListNode(-1);
        p = dummy2;
        for (int node : nodes2) {
            p.next = new ListNode(node);
            p = p.next;
        }
        ListNode ans = new Solution().mergeTwoLists(dummy1.next, dummy2.next);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
