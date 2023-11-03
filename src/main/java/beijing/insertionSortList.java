package beijing;
/*
https://leetcode-cn.com/problems/insertion-sort-list/
 */

public class insertionSortList {
    static class Solution {
        // 别人写的更简洁，效率更高
        public ListNode insertionSortList(ListNode head) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode pre;
            while (head != null && head.next != null) {
                if (head.val <= head.next.val) {
                    head = head.next;
                    continue;
                }
                pre = dummyHead;
                while (pre.next.val < head.next.val) {
                    pre = pre.next;
                }
                ListNode cur = head.next;
                head.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            return dummyHead.next;
        }
    }

    // 得画图，自己写的效率不高
    static class Solution0 {
        public ListNode insertionSortList(ListNode head) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode p = head.next;
            ListNode left = head;
            while (p != null) {
                ListNode right = p.next;
                left.next = null;
                p.next = null;
                ListNode findPos = dummyHead;
                while (findPos.next != null) {
                    if (p.val < findPos.next.val) {
                        ListNode next = findPos.next;
                        findPos.next = p;
                        p.next = next;
                        break;
                    }
                    findPos = findPos.next;
                }
                if (findPos.next == null) {
                    findPos.next = p;
                    p.next = right;
                    left = p;
                    p = p.next;
                } else {
                    p = right;
                }
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {-1, 5, 3, 4, 0};
        ListNode dummyhead = new ListNode(-1);
        ListNode p = dummyhead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        ListNode ans = new Solution().insertionSortList(dummyhead.next);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
