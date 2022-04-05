package Beijing;
/*
https://leetcode-cn.com/problems/sort-list/
 */

public class sortList {
    // 自底向上，不是自己写的
    static class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            int len = 0;
            ListNode p = head;
            while (p != null) {
                p = p.next;
                len++;
            }
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            for (int subLen = 1; subLen < len; subLen *= 2) {
                ListNode pre = dummyHead, cur = dummyHead.next;
                while (cur != null) {
                    ListNode head1 = cur;
                    for (int i = 1; i < subLen && cur.next != null; i++) {
                        cur = cur.next;
                    }
                    ListNode head2 = cur.next;
                    cur.next = null;
                    cur = head2;
                    for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
                        cur = cur.next;
                    }
                    ListNode next = null;
                    if (cur != null) {
                        next = cur.next;
                        cur.next = null;
                    }
                    ListNode merged = mergeList(head1, head2);
                    pre.next = merged;
                    while (pre.next != null) {
                        pre = pre.next;
                    }
                    cur = next;
                }
            }
            return dummyHead.next;
        }

        private ListNode mergeList(ListNode A, ListNode B) {
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
            while (A != null && B != null) {
                if (A.val < B.val) {
                    p.next = A;
                    A = A.next;
                } else {
                    p.next = B;
                    B = B.next;
                }
                p = p.next;
            }
            if (A != null) {
                p.next = A;
            }
            if (B != null) {
                p.next = B;
            }
            return dummyHead.next;
        }
    }

    // 自顶向下的归并排序，不是自己写的
    static class Solution1 {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode faster = head, slower = head, pre = null;
            while (faster != null && faster.next != null) {
                faster = faster.next.next;
                pre = slower;
                slower = slower.next;
            }
            pre.next = null;
            ListNode L = sortList(head);
            ListNode R = sortList(slower);
            return mergeList(L, R);
        }

        private ListNode mergeList(ListNode A, ListNode B) {
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
            while (A != null && B != null) {
                if (A.val < B.val) {
                    p.next = A;
                    A = A.next;
                } else {
                    p.next = B;
                    B = B.next;
                }
                p = p.next;
            }
            if (A != null) {
                p.next = A;
            }
            if (B != null) {
                p.next = B;
            }
            return dummyHead.next;
        }
    }

    // 超时了
    static class Solution0 {
        public ListNode sortList(ListNode head) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode p = dummyHead.next;
            while (p != null && p.next != null) {
                ListNode pos = dummyHead;
                while (p.next.val > pos.next.val) {
                    pos = pos.next;
                }
                swap(pos, p);
                if (pos == p) {
                    p = p.next;
                }
            }
            return dummyHead.next;
        }

        private void swap(ListNode prePos, ListNode preX) {
            ListNode x = preX.next;
            preX.next = preX.next.next;
            x.next = prePos.next;
            prePos.next = x;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {4, 2, 1, 2, 3};
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        ListNode ans = new Solution().sortList(dummyHead.next);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
