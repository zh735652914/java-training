package Beijing;
/*
https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */

// 自己写的
public class reverseKGroup {
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode p = dummyHead.next, per = dummyHead;
            while (p != null) {
                for (int i = 1; i < k; i++) {
                    if (p == null) {
                        break;
                    }
                    p = p.next;
                }
                if (p == null) {
                    break;
                }
                ListNode next = p.next;
                p.next = null;
                reverse(per.next);
                per.next = p;
                p = per.next;
                for (int i = 1; i < k; i++) {
                    p = p.next;
                }
                p.next = next;
                per = p;
                p = p.next;
            }
            return dummyHead.next;
        }

        private void reverse(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            reverse(head.next);
            head.next.next = head;
            head.next = null;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 2;
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        ListNode ans = new Solution().reverseKGroup(dummyHead.next, k);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
