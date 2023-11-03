package nowcoder;
/*
 牛客题霸-名企高频面试题
链表的奇偶重排
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 256M，其他语言512M 热度指数：227
本题知识点： 链表 排序
 算法知识视频讲解
题目描述
给定一个单链表，请设定一个函数，讲链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
注意是节点的编号而非节点的数值。

示例1
输入
复制
{1,2,3,4,5,6}
输出
复制
{1,3,5,2,4,6}
示例2
输入
复制
{1,4,6,3,7}
输出
复制
{1,6,7,4,3}
说明
奇数节点有1,6,7，偶数节点有4,3。重排后为1,6,7,4,3

备注:
链表长度不大于200000。每个数范围均在int内。
说明：本题目包含复杂数据结构ListNode，点此查看相关信息
 */

public class oddEvenList {
    static public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param head ListNode类
         * @return ListNode类
         */

        //超时了。。。
        public ListNode oddEvenList0(ListNode head) {
            ListNode perhead = new ListNode(-1), per_odd = new ListNode(-1), per_even = new ListNode(-1);
            ListNode p = head;
            ListNode odd = per_odd, even = per_even;
            boolean flag = false;
            while (p != null) {
                if (!flag) {
                    odd.next = p;
                    odd = odd.next;
                } else {
                    even.next = p;
                    even = even.next;
                }
                p = p.next;
                flag = !flag;
            }
            odd.next = per_even.next;
            even.next = null;
            perhead.next = per_odd.next;
            return perhead.next;
        }

        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode per_even = head.next;
            ListNode odd = head, even = head.next;
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = per_even;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        ListNode ans = new Solution().oddEvenList(perhead.next);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
