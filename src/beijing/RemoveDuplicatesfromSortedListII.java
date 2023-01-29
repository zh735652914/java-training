package beijing;

/*
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesfromSortedListII {
    // 别人的递归好理解一些
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = head.next;
            if (head.val == next.val) {
                while (next != null && next.val == head.val) {
                    next = next.next;
                }
                return deleteDuplicates(next);
            } else {
                head.next = deleteDuplicates(next);
            }
            return head;
        }
    }

    static class Solution0 {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode perAns = new ListNode(-1);
            perAns.next = head;
            ListNode last = perAns, p = last.next;
            while (p != null) {
                ListNode next = p.next;
                boolean flag = false;
                while (next != null && next.val == p.val) {
                    next = next.next;
                    flag = true;
                }
                if (!flag) {
                    last = last.next;
                } else {
                    last.next = next;
                }
                p = last.next;
            }
            return perAns.next;
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
        ListNode ans = new Solution().deleteDuplicates(perhead.next);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
