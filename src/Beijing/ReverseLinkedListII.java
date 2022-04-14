package Beijing;
/*
https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */

public class ReverseLinkedListII {
    // 这个写法自己不熟悉，得多看看，适用范围很广
    static class Solution1 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dunmmyHead = new ListNode(-1);
            dunmmyHead.next = head;
            ListNode pre = dunmmyHead;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }
            ListNode cur = pre.next;
            ListNode next;
            for (int i = left; i < right; i++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            return dunmmyHead.next;
        }

        private void reverse(ListNode head) {
            ListNode cur = head, pre = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
        }
    }

    // 自己写的不优美
    static class Solution0 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            int count = 0;
            ListNode L = head, R = head;
            ListNode PerAns = new ListNode(-1);
            PerAns.next = head;
            ListNode p = PerAns;
            while (p != null) {
                if (count + 1 == left) {
                    L = p;
                }
                if (count == right) {
                    R = p;
                    ListNode next = R.next;
                    R.next = null;
                    ListNode tmp = reverse(L.next);
                    if (tmp != null) {
                        tmp.next = next;
                    }
                    L.next = R;
                }
                count++;
                p = p.next;
            }
            return PerAns.next;
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = head.next;
            head.next = null;
            ListNode last = reverse(next);
            last.next = head;
            return head;
        }
    }

    // 自己又写了一次
    static class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummyHead = new ListNode(-1), pL = null, R = null;
            dummyHead.next = head;
            ListNode p = dummyHead, per = p;
            int count = 0;
            while (p != null) {
                if (count == left - 1) {
                    pL = p;
                }
                if (count == right) {
                    R = p;
                }
                p = p.next;
                count++;
            }
            ListNode next = R.next, L = pL.next;
            reverse(L, R);
            pL.next = R;
            L.next = next;
            return dummyHead.next;
        }

        private void reverse(ListNode L, ListNode R) {
            if (L == R) {
                return;
            }
            reverse(L.next, R);
            L.next.next = L;
            L.next = null;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int left = 2, right = 4;
        ListNode per = new ListNode(-1);
        ListNode p = per;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        ListNode ans = new Solution().reverseBetween(per.next, left, right);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
