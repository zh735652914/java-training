package beijing.hot100;
/*
https://leetcode.cn/problems/sort-list/
 */

public class sortList_148 {
    // 自己写的，不太好，后来看了解析又改了
    static class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
//            if (head.next.next == null) {
//                ListNode l2 = head.next;
//                head.next = null;
//                return merge(head, l2);
//            }
            ListNode faster = head, slower = head, pre = null;
            while (faster != null && faster.next != null) {
                faster = faster.next.next;
                pre = slower;
                slower = slower.next;
            }
            pre.next = null;
            ListNode l1 = sortList(head);
            ListNode l2 = sortList(slower);
            return merge(l1, l2);
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            if (l1 != null) {
                p.next = l1;
            }
            if (l2 != null) {
                p.next = l2;
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {4, 2, 1, 3};
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
