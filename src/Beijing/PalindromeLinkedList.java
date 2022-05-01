package Beijing;
/*
https://leetcode-cn.com/problems/palindrome-linked-list/
 */

import java.util.Stack;

public class PalindromeLinkedList {
    // 这个写起来要细心
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            ListNode faster = head, slower = head;
            while (faster != null && faster.next != null) {
                faster = faster.next.next;
                slower = slower.next;
            }
            ListNode next = slower.next;
            ListNode pre = null;
            while (next != null) {
                slower.next = pre;
                pre = slower;
                slower = next;
                next = slower.next;
            }
            slower.next = pre;
            while (slower != null) {
                if (slower.val != head.val) {
                    return false;
                }
                slower = slower.next;
                head = head.next;
            }
            return true;
        }
    }

    static class Solution0 {
        public boolean isPalindrome(ListNode head) {
            ListNode p = head;
            Stack<Integer> stack = new Stack<>();
            while (p != null) {
                stack.push(p.val);
                p = p.next;
            }
            p = head;
            while (p != null) {
                if (p.val != stack.pop()) {
                    return false;
                }
                p = p.next;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 2, 1};
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        System.out.println(new Solution().isPalindrome(dummyHead.next));
    }
}
