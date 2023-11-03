package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：37007
本题知识点： 链表
 算法知识视频讲解
题目描述
将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的。

示例1
输入
复制
{1},{}
输出
复制
{1}
示例2
输入
复制
{1},{1}
输出
复制
{1,1}
 */

public class mergeTwoLists {
    static public class Solution {
        /**
         * @param l1 ListNode类
         * @param l2 ListNode类
         * @return ListNode类
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode perhead = new ListNode(-1);
            ListNode p = perhead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            if (l1 != null) {
                p.next = l1;
            } else {
                p.next = l2;
            }
            return perhead.next;
        }
    }

    public static void main(String[] args) {
        int[] numsA = {1, 3, 5, 7};
        int[] numsB = {2, 4, 6, 8};
        ListNode l1 = mkList(numsA);
        ListNode l2 = mkList(numsB);
        ListNode ans = new Solution().mergeTwoLists(l1, l2);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
        System.out.println();
    }

    static private ListNode mkList(int[] nums) {
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        return perhead.next;
    }
}
