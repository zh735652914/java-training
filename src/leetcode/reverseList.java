package leetcode;
/*
206. 反转链表
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

通过次数328,768提交次数466,281
 */

public class reverseList {
    static class Solution {
        ListNode ans;

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            backtrack(head.next, head);
            return ans;
        }

        private ListNode backtrack(ListNode head, ListNode per) {
            if (head == null) {
                this.ans = per;
                return null;
            }
            per.next = null;
            ListNode next = backtrack(head.next, head);
            if (next != null) {
                next.next = head;
            }
            head.next = per;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        ListNode after = new Solution().reverseList(perhead.next);
        p = after;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
