package next;

import next.utils.ListNode;
import next.utils.ListUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author zhouhao
 * @date 2025/4/5 10:15
 * https://leetcode.cn/problems/palindrome-linked-list/
 */
public class LeetCode234_2 {
    public boolean isPalindrome(ListNode head) {
        ListNode faster = head;
        ListNode slower = head;
        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
        }
        ListNode right = reverse(slower);
        while (head != null && right != null) {
            if (head.val != right.val) {
                return false;
            }
            head = head.next;
            right = right.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    @Test
    public void test() {
        int[] nodes = {1, 2, 2, 1};
        ListNode head = ListUtils.buildList(nodes);
        assertTrue(isPalindrome(head));
    }
}
