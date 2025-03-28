package next;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/3/28 08:46
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/
 */
public class LeetCode142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode faster = head;
        ListNode slower = head;
        while (faster != null && faster.next != null && slower != null) {
            faster = faster.next.next;
            slower = slower.next;
            if (faster == slower) {
                slower = head;
                while (slower != faster) {
                    slower = slower.next;
                    faster = faster.next;
                }
                return faster;
            }
        }
        return null;
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
        assertEquals(cyc, detectCycle(preHead.next));
    }
}
