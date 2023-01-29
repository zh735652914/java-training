package beijing;
/*
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */

public class RemoveDuplicatesfromSortedList {
    static class Solution {
        public ListNode deleteDuplicates0(ListNode head) {
            ListNode perAns = new ListNode(-1);
            perAns.next = head;
            ListNode pos = perAns.next;
            while (pos != null) {
                ListNode next = pos.next;
                while (next != null && next.val == pos.val) {
                    next = next.next;
                }
                pos.next = next;
                pos = pos.next;
            }
            return perAns.next;
        }

        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = head.next;
            while (next != null && next.val == head.val) {
                next = next.next;
            }
            head.next = deleteDuplicates(next);
            return head;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 5};
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        ListNode ans = new RemoveDuplicatesfromSortedList.Solution().deleteDuplicates(perhead.next);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
