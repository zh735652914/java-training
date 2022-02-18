package Beijing;
/*
https://leetcode-cn.com/problems/rotate-list/
 */

public class RotateList {
    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return head;
            }
            ListNode start = head, tail = head, p = head;
            int count = 1;
            while (tail.next != null) {
                tail = tail.next;
                count++;
            }
            tail.next = head;
            k %= count;
            int index = count - k - 1;
            while (index-- > 0) {
                start = start.next;
            }
            ListNode ans = start.next;
            start.next = null;
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1};
        int k = 2;
        ListNode PerHead = new ListNode(-1);
        ListNode p = PerHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        ListNode ans = new Solution().rotateRight(PerHead.next, k);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
