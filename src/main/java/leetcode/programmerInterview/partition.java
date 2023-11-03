package leetcode.programmerInterview;
/*
面试题 02.04. Partition List LCCI
Write code to partition a linked list around a value x, such that all nodes less than x come before all
nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after
 the elements less than x (see below). The partition element x can appear anywhere in the "right partition";
  it does not need to appear between the left and right partitions.

Example:

Input: head = 3->5->8->5->10->2->1, x = 5
Output: 3->1->2->10->5->5->8
通过次数1,959提交次数3,039
 */

public class partition {
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode perhead = new ListNode(-1), bigger = new ListNode(-1), p = perhead, q = head, pos = bigger;
            p.next = q;
            while (q != null) {
                if (q.val >= x) {
                    pos.next = q;
                    pos = pos.next;
                    p.next = q.next;
                    q = q.next;
                } else {
                    p = p.next;
                    q = q.next;
                }
            }
            pos.next = null;
            p.next = bigger.next;
            return perhead.next;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {3, 5, 8, 5, 10, 2, 1};
        ListNode perhead = new ListNode(-1), p = perhead;
        for (int i = 0; i < nodes.length; i++) {
            p.next = new ListNode(nodes[i]);
            p = p.next;
        }
        int x = 5;
        ListNode ans = new Solution().partition(perhead.next, x);
        p = ans;
        while (p != null) {
            System.out.print(p.val + ",");
            p = p.next;
        }
        System.out.println();
    }
}
