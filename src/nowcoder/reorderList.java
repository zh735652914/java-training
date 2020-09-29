package nowcoder;
/*
 牛客题霸-名企高频面试题
重排链表 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：73274
本题知识点： 链表
 算法知识视频讲解
题目描述
将给定的单链表\ L L： L_0→L_1→…→L_{n-1}→L_ nL
0
​
 →L
1
​
 →…→L
n−1
​
 →L
n
​

重新排序为：L_0→L_n →L_1→L_{n-1}→L_2→L_{n-2}→…L
0
​
 →L
n
​
 →L
1
​
 →L
n−1
​
 →L
2
​
 →L
n−2
​
 →…
要求使用原地算法，不能改变节点内部的值，需要对实际的节点进行交换。
例如：
对于给定的单链表{10,20,30,40}，将其重新排序为{10,40,20,30}.

说明：本题目包含复杂数据结构ListNode，点此查看相关信息
 */

import java.util.Stack;

public class reorderList {
    static public class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            Stack<ListNode> stack = new Stack<>();
            ListNode p = head;
            while (p != null) {
                stack.push(p);
                p = p.next;
            }
            ListNode perhead = new ListNode(-1);
            perhead.next = head;
            p = head;
            int count = (stack.size() + 1) / 2;
            while (count-- > 0 && stack.peek() != p) {
                ListNode next = p.next;
                p.next = stack.pop();
                p = p.next;
                p.next = next;
                p = p.next;
            }
            p.next = null;

            OUTPUT(perhead.next);
        }

        private void OUTPUT(ListNode head) {
            while (head != null) {
                System.out.print(head.val + "->");
                head = head.next;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40};
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        new Solution().reorderList(perhead.next);
    }
}
