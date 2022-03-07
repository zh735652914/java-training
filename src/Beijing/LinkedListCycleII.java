package Beijing;
/*
https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */

public class LinkedListCycleII {
    // 这题写过，但是忘记怎么证明的了
    static public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    break;
                }
            }
            if (fast == null || fast.next == null) {
                return null;
            }
            ListNode pos = head;
            while (pos != fast) {
                fast = fast.next;
                pos = pos.next;
            }
            return pos;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2};
        int pos = 0;
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        ListNode cycle = null;
        for (int i = 0; i < nodes.length; i++) {
            p.next = new ListNode(nodes[i]);
            if (i == pos) {
                cycle = p.next;
            }
            p = p.next;
        }
        p.next = cycle;
        System.out.println(new Solution().detectCycle(dummyHead.next).val);
    }
}
