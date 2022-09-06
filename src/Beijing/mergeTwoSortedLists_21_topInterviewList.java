package Beijing;
/*
https://leetcode.cn/problems/merge-two-sorted-lists/
 */

// 的确写了太多次了
public class mergeTwoSortedLists_21_topInterviewList {
    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    p.next = list1;
                    list1 = list1.next;
                } else {
                    p.next = list2;
                    list2 = list2.next;
                }
                p = p.next;
            }
            if (list1 != null) {
                p.next = list1;
            }
            if (list2 != null) {
                p.next = list2;
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        int[] nodes1 = {1, 2, 4};
        int[] nodes2 = {1, 3, 4};
        ListNode list1 = mkList(nodes1);
        ListNode list2 = mkList(nodes2);
        ListNode ans = new Solution().mergeTwoLists(list1, list2);
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
