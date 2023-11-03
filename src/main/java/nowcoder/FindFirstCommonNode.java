package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：410272
本题知识点： 链表
 算法知识视频讲解
题目描述
输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */

public class FindFirstCommonNode {
    static public class Solution {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            ListNode p = pHead1;
            ListNode q = pHead2;
            while (p != q) {
                p = p == null ? pHead2 : p.next;
                q = q == null ? pHead1 : q.next;
            }
            return p;
        }
    }

    public static void main(String[] args) {
        int[] numsA = {1, 2, 3, 4, 5, 6};
        int[] numsB = {7, 8, 9};
        int cyc = 4;
        ListNode perheadA = new ListNode(-1);
        ListNode p = perheadA;
        ListNode CY = null;
        for (int num : numsA) {
            p.next = new ListNode(num);
            p = p.next;
            if (num == cyc) {
                CY = p;
            }
        }
        ListNode perheadB = new ListNode(-1);
        p = perheadB;
        for (int nums : numsB) {
            p.next = new ListNode(nums);
            p = p.next;
        }
        p.next = CY;
        System.out.println(new Solution().FindFirstCommonNode(perheadA.next, perheadB.next).val);
    }
}
