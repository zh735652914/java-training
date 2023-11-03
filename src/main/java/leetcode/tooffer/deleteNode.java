package leetcode.tooffer;
/*
面试题18. 删除链表的节点
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

注意：此题对比原题有改动

示例 1:

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.


说明：

题目保证链表中节点的值互不相同
若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
通过次数3,904提交次数6,475
 */

import java.util.Scanner;

public class deleteNode {
    static class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            if (head == null) return null;
            ListNode p = new ListNode(-1), perhead = p;
            ListNode q = head;
            p.next = q;
            while (q != null) {
                if (q.val == val) {
                    p.next = q.next;
                    return perhead.next;
                }
                q = q.next;
                p = p.next;
            }

            return perhead.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] Arr = scanner.nextLine().split(",");
        int[] nums = new int[Arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(Arr[i]);
        }
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        ListNode after = new Solution().deleteNode(head, scanner.nextInt());
        p = after;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
