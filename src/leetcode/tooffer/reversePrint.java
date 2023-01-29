package leetcode.tooffer;
/*
面试题06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。



示例 1：

输入：head = [1,3,2]
输出：[2,3,1]


限制：

0 <= 链表长度 <= 10000

通过次数6,500提交次数8,399
 */

import java.util.Scanner;
import java.util.Stack;

public class reversePrint {
    static class Solution {
        public int[] reversePrint(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            ListNode p = head;
            while (p != null) {
                stack.push(p);
                p = p.next;
            }
            int[] ans = new int[stack.size()];
            int index = 0;
            while (!stack.isEmpty()) {
                ans[index++] = stack.pop().val;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] input = scanner.nextLine().split(",");
            ListNode head = new ListNode(Integer.parseInt(input[0]));
            ListNode p = head;
            for (int i = 1; i < input.length; i++) {
                p.next = new ListNode(Integer.parseInt(input[i]));
                p = p.next;
            }
            int[] ans = new Solution().reversePrint(head);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
