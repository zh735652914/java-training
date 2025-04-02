package next;

import next.utils.ListNode;
import next.utils.ListUtils;
import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/4/2 08:41
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    @Test
    public void test() {
        int[] nodes = {1, 2, 3, 4, 5};
        ListNode head = ListUtils.buildList(nodes);
        ListNode ans = reverseList(head);
        ListUtils.printList(ans);
    }
}
