package Beijing;
/*
https://leetcode.cn/problems/linked-list-cycle/
 */

public class linkedListCycle_141 {
    // 写了很多次了
    static public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode faster = head.next, slower = head;
            while (faster != null && faster.next != null && slower != null) {
                faster = faster.next.next;
                slower = slower.next;
                if (faster == slower) {
                    return true;
                }
            }
            return false;
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
        System.out.println(new Solution().hasCycle(dummyHead.next));
    }
}
