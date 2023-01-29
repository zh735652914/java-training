package leetcode;
/*
143. 重排链表
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
通过次数37,355提交次数66,096
 */

import java.util.Stack;

public class reorderList {
    static class Solution {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            Stack<ListNode> stack = new Stack<>();
            ListNode p = head;
            while (p != null) {
                stack.push(p);
                p = p.next;
            }
            int count = stack.size() / 2;
            p = head;
            ListNode next;
            for (int i = 0; i < count; i++) {
                next = p.next;
                p.next = stack.pop();
                p = p.next;
                p.next = next;
                p = p.next;
            }
            p.next = null;
            output(head);
        }

        private void output(ListNode head) {
            ListNode p = head;
            while (p != null) {
                System.out.print(p.val + "->");
                p = p.next;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        new Solution().reorderList(perhead.next);
    }
}
