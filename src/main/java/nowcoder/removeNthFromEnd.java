package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：32721
本题知识点： 链表 双指针
 算法知识视频讲解
题目描述
给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
例如，
 给出的链表为:1->2->3->4->5, n= 2.
 删除了链表的倒数第n个节点之后,链表变为1->2->3->5.
备注：
题目保证n一定是有效的
请给出请给出时间复杂度为\ O(n) O(n)的算法

示例1
输入
复制
{1,2},2
输出
复制
{2}
 */

public class removeNthFromEnd {
    static public class Solution {
        /**
         * @param head ListNode类
         * @param n    int整型
         * @return ListNode类
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode faster = head, slower = head;
            while (n-- > 0 && faster != null) {
                faster = faster.next;
            }
            ListNode perhead = new ListNode(-1);
            perhead.next = head;
            ListNode per = perhead;
            while (faster != null) {
                per = per.next;
                slower = slower.next;
                faster = faster.next;
            }
            per.next = slower.next;
            return perhead.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int n = 2;
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        p = new Solution().removeNthFromEnd(perhead.next, n);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();
    }
}
