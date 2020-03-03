package LeetCode.ToOffer;
/*
面试题24. 反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。



示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL


限制：

0 <= 节点个数 <= 5000



注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/

通过次数5,781提交次数7,508
 */

import java.util.Scanner;
import java.util.Stack;

public class reverseList {
    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) return null;
            Stack<ListNode> stack = new Stack<>();
            ListNode p = head;
            while (p != null) {
                stack.push(p);
                p = p.next;
            }
            ListNode after = stack.pop();
            p = after;
            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
                if (stack.isEmpty()) {
                    p.next = null;
                    break;
                }
            }
            return after;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] Arr = scanner.nextLine().split(",");
//        int[] nums = new int[Arr.length];
        ListNode head = new ListNode(Integer.parseInt(Arr[0]));
        ListNode p = head;
        for (int i = 1; i < Arr.length; i++) {
            p.next = new ListNode(Integer.parseInt(Arr[i]));
            p = p.next;
        }
        p = new Solution().reverseList(head);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();
    }
}
