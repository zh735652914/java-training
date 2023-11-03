package nowcoder;
/*
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：6919
本题知识点： 链表 双指针
 算法知识视频讲解
题目描述
给定一个链表，请判断该链表是否为回文结构。
示例1
输入
复制
[1,2,2,1]
输出
复制
true
备注:
1 \leq n \leq 10^61≤n≤10
6
 */

import java.util.Stack;

public class isPail {
    static public class Solution {
        /**
         * @param head ListNode类 the head
         * @return bool布尔型
         */
        public boolean isPail(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            ListNode p = head;
            while (p != null) {
                stack.push(p.val);
                p = p.next;
            }
            p = head;
            while (!stack.isEmpty()) {
                if (stack.peek() != p.val) {
                    return false;
                }
                stack.pop();
                p = p.next;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 2, 1};
        ListNode prehead = new ListNode(-1);
        ListNode p = prehead;
        for (int num : nodes) {
            p.next = new ListNode(num);
            p = p.next;
        }
        System.out.println(new Solution().isPail(prehead.next));
    }
}
