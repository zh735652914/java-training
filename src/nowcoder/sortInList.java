package nowcoder;
/*
 牛客题霸-名企高频面试题
单链表的选择排序
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：557
 算法知识视频讲解
题目描述
给定一个无序单链表，实现单链表的选择排序(按升序排序)。
示例1
输入
复制
[1,3,2,4,5]
输出
复制
{1,2,3,4,5}
说明：本题目包含复杂数据结构ListNode，点此查看相关信息
 */

public class sortInList {
    static public class Solution {
        /**
         * @param head ListNode类 the head node
         * @return ListNode类
         */
        public ListNode sortInList(ListNode head) {
            ListNode perhead = new ListNode(-1);
            ListNode p = perhead;
            ListNode q = head;
            p.next = q;
            p = p.next;
            q = q.next;
            p.next = null;
            while (q != null) {
                p = perhead;
                ListNode next_q = q.next;
                while (p.next != null && p.next.val < q.val) {
                    p = p.next;
                }

                if (p.next == null) {
                    p.next = q;
                    p.next.next = null;
                } else {
                    ListNode next = p.next;
                    p.next = q;
                    p.next.next = next;
                }
                q = next_q;
            }
            return perhead.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 5};
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        p = new Solution().sortInList(perhead.next);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
