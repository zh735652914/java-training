package Beijing;
/*
https://leetcode.cn/problems/palindrome-linked-list/
 */

public class PalindromeLinkedList_234_topInterviewList {
    // 反转链表要背下来
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode slower = head, faster = head.next;
            while (faster != null && faster.next != null) {
                faster = faster.next.next;
                slower = slower.next;
            }
            ListNode R = reverseList(slower.next);
            while (R != null && head != null) {
                if (head.val != R.val) {
                    return false;
                }
                head = head.next;
                R = R.next;
            }
            return true;
        }

        private ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 2, 1};// 1,2,2,1,3
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        System.out.println(new Solution().isPalindrome(dummyHead.next));
    }
}
