package Beijing.hot100;
/*
https://leetcode.cn/problems/linked-list-cycle/
 */

public class linkedListCycle_141 {
    // 很简单
    static public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode faster = head.next, slower = head;
            while (faster != null && faster.next != null && faster != slower) {
                faster = faster.next.next;
                slower = slower.next;
            }
            return faster == slower;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {3, 2, 0, -4};
        int pos = 1;
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead, cycle = null;
        for (int i = 0; i < nodes.length; i++) {
            ListNode cur = new ListNode(nodes[i]);
            p.next = cur;
            p = p.next;
            if (i == pos) {
                cycle = cur;
            }
        }
        p.next = cycle;
        System.out.println(new Solution().hasCycle(dummyHead.next));
    }
}
