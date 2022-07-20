package Beijing;
/*
https://leetcode.cn/problems/sort-list/
 */

// 第三次了，还是不会写
public class sortList_148 {
    static class Solution {
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

        private ListNode mergeList(ListNode left, ListNode right) {
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    p.next = left;
                    left = left.next;
                } else {
                    p.next = right;
                    right = right.next;
                }
                p = p.next;
            }
            if (left != null) {
                p.next = left;
            }
            if (right != null) {
                p.next = right;
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        ListNode ans = new Solution().sortList(dummyHead.next);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
