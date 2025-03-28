package next;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author zhouhao
 * @date 2025/3/28 08:35
 * https://leetcode.cn/problems/linked-list-cycle/
 */
public class LeetCode141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode faster = head.next;
        ListNode slower = head;
        while (faster != null && faster.next != null && slower != null) {
            if (faster == slower) {
                return true;
            }
            faster = faster.next.next;
            slower = slower.next;
        }
        return false;
    }

    @Test
    public void test() {
        int[] nodes = {3, 2, 0, -4};
        int pos = 1;
        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;
        ListNode cyc = null;
        for (int i = 0; i < nodes.length; i++) {
            p.next = new ListNode(nodes[i]);
            p = p.next;
            if (i == pos) {
                cyc = p;
            }
        }
        p.next = cyc;
        assertTrue(hasCycle(preHead.next));
    }
}
