package Beijing;
/*
https://leetcode.cn/problems/linked-list-cycle-ii/
 */

public class linkedListCycleII_142 {
    // 很简单，但是这次写不太顺利
    static public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode faster = head, slower = head;
            while (faster != null && faster.next != null && slower != null) {
                faster = faster.next.next;
                slower = slower.next;
                if (faster == slower) {
                    break;
                }
            }
            if (faster == null || slower == null || faster.next == null) {
                return null;
            }
            slower = head;
            while (slower != faster) {
                slower = slower.next;
                faster = faster.next;
            }
            return faster;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {3, 2, 0, -4};
        ListNode dummyHead = new ListNode(-1);
        int pos = 1;
        ListNode p = dummyHead;
        ListNode cyc = null;
        for (int i = 0; i < nodes.length; i++) {
            ListNode cur = new ListNode(nodes[i]);
            if (i == pos) {
                cyc = cur;
            }
            p.next = cur;
            p = p.next;
        }
        p.next = cyc;
        ListNode ans = new Solution().detectCycle(dummyHead.next);
        System.out.println(ans == null ? "null" : ans.val);
    }
}
