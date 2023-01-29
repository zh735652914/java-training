package leetcode.tooffer;
/*
面试题25. 合并两个排序的链表
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：

0 <= 链表长度 <= 1000

注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/

通过次数4,075提交次数5,334
 */

import java.util.Scanner;

public class mergeTwoLists {
    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode perhead = new ListNode(-1);
            ListNode p = perhead;
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
            if (l1 != null) p.next = l1;
            if (l2 != null) p.next = l2;
            return perhead.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mergeTwoLists mergeTwoLists = new mergeTwoLists();
        ListNode head1 = mergeTwoLists.makeList(scanner.nextLine().split(","));
        ListNode head2 = mergeTwoLists.makeList(scanner.nextLine().split(","));
        ListNode p = new Solution().mergeTwoLists(head1, head2);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();
    }

    private ListNode makeList(String[] nodes) {
        if (nodes == null || nodes.length == 0) return null;
        ListNode head = new ListNode(Integer.parseInt(nodes[0]));
        ListNode p = head;
        for (int i = 1; i < nodes.length; i++) {
            p.next = new ListNode(Integer.parseInt(nodes[i]));
            p = p.next;
        }
        return head;
    }
}
