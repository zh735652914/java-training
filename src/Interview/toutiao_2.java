package Interview;
/*
25. K 个一组翻转链表
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。



示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5



说明：

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
通过次数100,357提交次数159,533
 */


public class toutiao_2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k == 1) {
                return head;
            }
            ListNode end = head;
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                return head;
            }
            ListNode next = end.next;
            reverse(head, end);
            head.next = reverseKGroup(next, k);
            return end;
        }

        private void reverse(ListNode start, ListNode end) {
            if (start == end) {
                return;
            }
            reverse(start.next, end);
            start.next.next = start;
            start.next = null;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        ListNode ans = new Solution().reverseKGroup(perhead.next, k);
        p = ans;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();
    }
}
