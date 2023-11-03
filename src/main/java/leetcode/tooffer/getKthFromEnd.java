package leetcode.tooffer;
/*
面试题22. 链表中倒数第k个节点
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。



示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
通过次数5,204提交次数6,429
 */

import java.util.Scanner;

public class getKthFromEnd {
    static class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode fast = head;
            ListNode slow = head;
            for (int i = 0; i < k && fast != null; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] Arr = scanner.nextLine().split(",");
        int[] nums = new int[Arr.length];
        for (int i = 0; i < Arr.length; i++) {
            nums[i] = Integer.parseInt(Arr[i]);
        }
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        ListNode rest = new Solution().getKthFromEnd(head, scanner.nextInt());
        p = rest;
        while (p != null) {
            System.out.print(p.val + " -> ");
            p = p.next;
        }
    }
}
