package nowcoder;
/*
 牛客题霸-名企高频面试题
删除有序链表中重复出现的元素 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：21066
本题知识点： 链表
 算法知识视频讲解
题目描述
给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
例如：
给出的链表为1 \to 2\to 3\to 3\to 4\to 4\to51→2→3→3→4→4→5, 返回1\to 2\to51→2→5.
给出的链表为1\to1 \to 1\to 2 \to 31→1→1→2→3, 返回2\to 32→3.



示例1
输入
复制
{1,2,2}
输出
复制
{1}
说明：本题目包含复杂数据结构ListNode，点此查看相关信息
 */

public class deleteDuplicates {
    static public class Solution {
        /**
         * @param head ListNode类
         * @return ListNode类
         */
        public ListNode deleteDuplicates(ListNode head) {
            ListNode perhead = new ListNode(-1);
            perhead.next = head;
            ListNode per = perhead;
            ListNode p = head;
            ListNode last = per;
            while (p != null) {
                if (p.next == null || p.val != p.next.val) {
                    last = p;
                } else {
                    while (p.next != null && p.val == p.next.val) {
                        p = p.next;
                    }
                    last.next = p.next;
                }
                p = p.next;
            }
            return perhead.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3};
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        p = new Solution().deleteDuplicates(perhead.next);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();
    }
}
