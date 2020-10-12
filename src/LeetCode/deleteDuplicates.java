package LeetCode;

public class deleteDuplicates {
    static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //链表去重
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            head.next = deleteDuplicates(head.next);
            if (head.next.val == head.val) {
                head = head.next;
            }
            return head;
        }
    }

    //删除所有重复出现的节点
    static class Solution1 {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode perhead = new ListNode(-1);
            perhead.next = head;
            ListNode p = perhead;
            while (p.next != null) {
                if (p.next.next == null || p.next.next.val != p.next.val) {
                    p = p.next;
                    continue;
                }
                ListNode per = p;
                while (p.next.next != null && p.next.val == p.next.next.val) {
                    p = p.next;
                }
                per.next = p.next.next;
                p = per;
            }
            return perhead.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4};
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int x : nums) {
            p.next = new ListNode(x);
            p = p.next;
        }
        p = new Solution().deleteDuplicates(perhead.next);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
