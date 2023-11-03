package leetcode;
/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

import java.util.Stack;

class ReverseLinkedListSolution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        Stack<ListNode> S = new Stack<>();
        ListNode p = head;
        while (p != null) {
            S.push(p);
            p = p.next;
        }
        ListNode Nhead = S.pop();
        p = Nhead;
        while (!S.empty()) {
            p.next = S.pop();
            p = p.next;
        }
        p.next = null;
        return Nhead;
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = null, p = head;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                head = new ListNode(nums[0]);
                p = head;
            }
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        ReverseLinkedListSolution reverseLinkedListSolution = new ReverseLinkedListSolution();
        System.out.println("原链表为：");
        p = head;
        while (p != null) {
            if (p.next == null) {
                System.out.println(p.val);
            } else {
                System.out.print(p.val + "->");
            }
            p = p.next;
        }

        System.out.println("翻转后链表为：");
        p = reverseLinkedListSolution.reverseList(head);
        while (p != null) {
            if (p.next == null) {
                System.out.println(p.val);
            } else {
                System.out.print(p.val + "->");
            }
            p = p.next;
        }
    }
}
