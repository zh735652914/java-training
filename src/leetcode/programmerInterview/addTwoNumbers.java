package leetcode.programmerInterview;
/*
面试题 02.05. 链表求和
给定两个用链表表示的整数，每个节点包含一个数位。

这些数位是反向存放的，也就是个位排在链表首部。

编写函数对这两个整数求和，并用链表形式返回结果。



示例：

输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
输出：2 -> 1 -> 9，即912
进阶：假设这些数位是正向存放的，请再做一遍。

示例：

输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
输出：9 -> 1 -> 2，即912
通过次数2,444提交次数5,289
 */

import java.util.Stack;

public class addTwoNumbers {
    static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode p = l1, q = l2, perhead = new ListNode(-1), pos = perhead;
            int x = 0, y = 0, sum = 0;
            while (p != null || q != null || carry != 0) {
                x = p == null ? 0 : p.val;
                y = q == null ? 0 : q.val;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
                sum = x + y + carry;
                pos.next = new ListNode(sum % 10);
                carry = sum / 10;
                pos = pos.next;
            }
            return perhead.next;
        }

        //暴力是不行的
        public ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
            long x = num(l1) + num(l2);
            ListNode per = new ListNode(-1), p = per;
            if (x == 0) return new ListNode(0);
            while (x != 0) {
                p.next = new ListNode((int) (x % 10));
                x /= 10;
                p = p.next;
            }
            return per.next;
        }

        private long num(ListNode head) {
            ListNode p = head;
            Stack<Integer> stack = new Stack<>();
            while (p != null) {
                stack.push(p.val);
                p = p.next;
            }
            long num = 0;
            while (!stack.isEmpty()) {
                num *= 10;
                num += stack.pop();
            }
            return num;
        }
    }

    public static void main(String[] args) {
//        int[] nodes1 = {7, 1, 6};
//        int[] nodes2 = {5, 9, 2};
        int[] nodes1 = {9};
        int[] nodes2 = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        addTwoNumbers addTwoNumbers = new addTwoNumbers();
        ListNode l1 = addTwoNumbers.makelist(nodes1);
        ListNode l2 = addTwoNumbers.makelist(nodes2);
        ListNode p = new Solution().addTwoNumbers(l1, l2);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();
    }

    private ListNode makelist(int[] nodes) {
        ListNode perhead = new ListNode(-1), p = perhead;
        for (int i = 0; i < nodes.length; i++) {
            p.next = new ListNode(nodes[i]);
            p = p.next;
        }
        return perhead.next;
    }
}
