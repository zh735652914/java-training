package leetcode;
/*
328. Odd Even Linked List
Medium

1160

264

Add to List

Share
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are
 talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
 */

public class oddEvenList {
    static class oddEvenListSolution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) return head;
            ListNode even = head.next;
            if (even == null || even.next == null) return head;
            ListNode p = head, q = even, curr = q.next;
            int count = 1;
            while (curr != null) {
                if (count % 2 == 1) {
                    p.next = curr;
                    p = p.next;
                } else {
                    q.next = curr;
                    q = q.next;
                }
                curr = curr.next;
                count++;
            }
            p.next = even;
            q.next = null;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6, 4, 7};
        ListNode head = null;
        if (nums == null || nums.length == 0) {
            head = null;
        } else {
            head = new ListNode(nums[0]);
        }
        ListNode p = head;
        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        ListNode after = new oddEvenListSolution().oddEvenList(head);
        p = after;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
