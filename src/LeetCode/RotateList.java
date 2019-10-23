package LeetCode;

import jdk.internal.org.objectweb.asm.Handle;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 */
class RotateListSolution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode p = head;
        int len = 1;
        while (p.next != null) {
            len++;
            p = p.next;
        }
        ListNode tail = p;
        int pos = len - (k % len);
        if (pos == len) {
            return head;
        }
        p = head;
        ListNode q = head;
//        p = p.next;
        for (int i = 0; i < pos; i++) {
            if (i == 0) {
                p = p.next;
                continue;
            }
            p = p.next;
            q = q.next;
        }
        ListNode ans = p;
        tail.next = head;
        q.next = null;
        return ans;
    }
}

public class RotateList {
    public static void main(String[] args) {
//        int[] nums = {0, 1, 2};
        int[] nums = {1, 2, 3, 4, 5};
//        int[] nums = {1};
        int k = 5;
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        RotateListSolution RL = new RotateListSolution();
        ListNode ans = RL.rotateRight(head, k);
        ListNode tmp = ans;
        while (tmp != null) {
            System.out.print(tmp.val + "=>");
            tmp = tmp.next;
        }
    }
}
