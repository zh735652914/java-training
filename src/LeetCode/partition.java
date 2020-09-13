package LeetCode;
/*
86. 分隔链表
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

示例:

输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5
通过次数51,955提交次数87,214
 */

public class partition {
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode perbigger = new ListNode(-1), bigger = perbigger;
            ListNode perhead = new ListNode(-1);
            perhead.next = head;
            ListNode p = perhead;
            while (p.next != null) {
                if (p.next.val >= x) {
                    bigger.next = p.next;
                    bigger = bigger.next;
                    if (p.next.next == null) {
                        p.next = null;
                    } else {
                        p.next = p.next.next;
                    }
                    bigger.next = null;
                } else {
                    p = p.next;
                }
            }

            p.next = perbigger.next;
            return perhead.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5, 2};
        int x = 3;
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        p = new Solution().partition(perhead.next, x);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();
    }
}
