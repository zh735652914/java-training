package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/22 09:24
 * https://leetcode.cn/problems/palindrome-linked-list/
 */
public class LeetCode234 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode faster = head, slower = head;
        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
        }
        ListNode right = reverseList(slower);
        while (head != null && right != null) {
            if (head.val != right.val) {
                return false;
            }
            head = head.next;
            right = right.next;
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

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 2, 1};
        ListNode head = buildList(nums);
        System.out.println(isPalindrome(head));
    }

    private ListNode buildList(int[] nodes) {
        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        return preHead.next;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
