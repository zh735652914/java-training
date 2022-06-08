package Beijing.hot100;
/*
https://leetcode.cn/problems/palindrome-linked-list/
 */

import java.util.Stack;

public class palindromeLinkedList_234 {
    // 虽然是简单题，但是翻转链表的写法很重要
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode faster = head, slower = head;
            while (faster != null && faster.next != null) {
                faster = faster.next.next;
                slower = slower.next;
            }
            slower = reverseLisNode(slower);
            while (slower != null) {
                if (slower.val != head.val) {
                    return false;
                }
                slower = slower.next;
                head = head.next;
            }
            return true;
        }

        private ListNode reverseLisNode(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseLisNode(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }


    static class Solution1 {
        public boolean isPalindrome(ListNode head) {
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
            while (head != null) {
                if (head.val != stack.pop()) {
                    return false;
                }
                head = head.next;
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
