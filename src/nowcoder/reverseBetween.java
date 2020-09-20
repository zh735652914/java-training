package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：27159
本题知识点： 链表
 算法知识视频讲解
题目描述
将一个链表\ m m 位置到\ n n 位置之间的区间反转，要求时间复杂度 ，空间复杂度 。
例如：
给出的链表为 1\to 2 \to 3 \to 4 \to 5 \to NULL1→2→3→4→5→NULL, ，,
返回 1\to 4\to 3\to 2\to 5\to NULL1→4→3→2→5→NULL.
注意：
给出的 满足以下条件：
1 \leq m \leq n \leq 链表长度1≤m≤n≤链表长度
示例1
输入
复制
{1,2,3,4,5},2,4
输出
复制
{1,4,3,2,5}
 */

public class reverseBetween {
    static public class Solution {
        /**
         * @param head ListNode类
         * @param m    int整型
         * @param n    int整型
         * @return ListNode类
         */
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode per = new ListNode(-1);
            per.next = head;
            ListNode p = per, left = null, right = null;
            int index = 0;
            while (p != null) {
                if (index == m - 1) {
                    left = p;
                }
                if (index == n) {
                    right = p;
                }
                p = p.next;
                index++;
            }
            ListNode next = right.next;
            rever(left.next, right);
            left.next.next = next;
            left.next = right;
            return per.next;
        }

        private void rever(ListNode head, ListNode tail) {
            if (head == tail) {
                return;
            }
            rever(head.next, tail);
            head.next.next = head;
            head.next = null;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int m = 1, n = 4;
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        ListNode ans = new Solution().reverseBetween(perhead.next, m, n);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
        System.out.println();
    }
}
