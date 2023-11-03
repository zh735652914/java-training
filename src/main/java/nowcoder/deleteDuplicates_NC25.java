package nowcoder;
/*
 牛客题霸-名企高频面试题
删除有序链表中重复的元素 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：21357
本题知识点： 链表
 算法知识视频讲解
题目描述
删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
例如：
给出的链表为1\to1\to21→1→2,返回1 \to 21→2.
给出的链表为1\to1\to 2 \to 3 \to 31→1→2→3→3,返回1\to 2 \to 31→2→3.

示例1
输入
复制
{1,1,2}
输出
复制
{1,2}
 */

public class deleteDuplicates_NC25 {
    static public class Solution {
        /**
         * @param head ListNode类
         * @return ListNode类
         */
        public ListNode deleteDuplicates(ListNode head) {
            ListNode perhead = new ListNode(-1);
            perhead.next = head;
            ListNode p = head;
            while (p != null && p.next != null) {
                if (p.val == p.next.val) {
                    p.next = p.next.next;
                } else {
                    p = p.next;
                }
            }
            return perhead.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3};
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        ListNode ans = new Solution().deleteDuplicates(perhead.next);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
