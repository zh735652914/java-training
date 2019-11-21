package LeetCode;
/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 */
//自己写的，但是太慢了。。空间效率还可以，但是时间效率太低

import java.util.Stack;

class PalindromeLinkedListSolution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        p = head;
        while (p != null) {
            if (p.val != stack.pop()) return false;
            p = p.next;
        }
        return true;
    }
}

public class PalindromeLinkedList {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 2, 1};
        int[] nums = {1, 2};
        ListNode pre = new ListNode(-1);
        ListNode p = pre;
        for (int i = 0; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        PalindromeLinkedListSolution palindromeLinkedListSolution = new PalindromeLinkedListSolution();
        System.out.println(palindromeLinkedListSolution.isPalindrome(pre.next));
    }
}
