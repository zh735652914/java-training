package nowcoder;
/*
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：14027
本题知识点： 链表
 算法知识视频讲解
题目描述
假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
给定两个这种链表，请生成代表两个整数相加值的结果链表。
例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
示例1
输入
复制
[9,3,7],[6,3]
输出
复制
{1,0,0,0}
备注:
1 \leq n, m \leq 10^61≤n,m≤10
6

0 \leq a_i, b_i \leq 90≤a
i
​
 ,b
i
​
 ≤9
 */

import org.omg.CORBA.INTERNAL;

import java.util.Stack;

public class addInList {
    static public class Solution {
        /**
         * @param head1 ListNode类
         * @param head2 ListNode类
         * @return ListNode类
         */

        //超时了，只能过75%
        public ListNode addInList(ListNode head1, ListNode head2) {
            Stack<ListNode> A = new Stack<>();
            Stack<ListNode> B = new Stack<>();
            ListNode p = head1, q = head2;
            while (p != null) {
                A.push(p);
                p = p.next;
            }
            while (q != null) {
                B.push(q);
                q = q.next;
            }
            int carry = 0, x = 0, y = 0, sum = 0;
            ListNode last = null;
            while (!A.isEmpty() || !B.isEmpty()) {
                if (carry == 0) {
                    if (A.isEmpty()) {
                        B.peek().next = last;
                        return head2;
                    }
                    if (B.isEmpty()) {
                        A.peek().next = last;
                        return head1;
                    }
                }

                x = !A.isEmpty() ? A.pop().val : 0;
                y = !B.isEmpty() ? B.pop().val : 0;

                sum = x + y + carry;
                carry = sum / 10;
                ListNode curr = new ListNode(sum % 10);
                curr.next = last;
                last = curr;
            }
            while (carry > 0) {
                ListNode curr = new ListNode(carry % 10);
                carry /= 10;
                curr.next = last;
                last = curr;
            }
            return last;
        }

    }

    public static void main(String[] args) {
        int[] numsA = {9, 3, 7};
        int[] numsB = {6, 3};
        ListNode head1 = mkList(numsA);
        ListNode head2 = mkList(numsB);
        ListNode ans = new Solution().addInList(head1, head2);
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
