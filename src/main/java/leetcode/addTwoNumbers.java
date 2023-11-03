package leetcode;
/*
2. 两数相加
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
通过次数596,544提交次数1,540,430
 */

public class addTwoNumbers {
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1.val == 0 && l1.next == null) {
                return l2;
            }
            if (l2.val == 0 && l2.next == null) {
                return l1;
            }
            ListNode perhead = new ListNode(-1);
            ListNode p = perhead;
            int carry = 0;
            while (l1 != null && l2 != null) {
                int cur = l1.val + l2.val + carry;
                p.next = new ListNode(cur % 10);
                carry = cur / 10;
                l1 = l1.next;
                l2 = l2.next;
                p = p.next;
            }
            while (l1 != null) {
                int cur = l1.val + carry;
                p.next = new ListNode(cur % 10);
                carry = cur / 10;
                l1 = l1.next;
                p = p.next;
            }
            while (l2 != null) {
                int cur = l2.val + carry;
                p.next = new ListNode(cur % 10);
                carry = cur / 10;
                l2 = l2.next;
                p = p.next;
            }
            while (carry > 0) {
                p.next = new ListNode(carry % 10);
                carry /= 10;
                p = p.next;
            }
            return perhead.next;
        }
    }

    public static void main(String[] args) {
        int x = 342, y = 465;
        ListNode perL1 = new ListNode(-1);
        ListNode perL2 = new ListNode(-1);
        ListNode p = perL1;
        while (x > 0) {
            p.next = new ListNode(x % 10);
            x /= 10;
            p = p.next;
        }
        p = perL2;
        while (y > 0) {
            p.next = new ListNode(y % 10);
            y /= 10;
            p = p.next;
        }
        p = new Solution().addTwoNumbers(perL1.next, perL2.next);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
