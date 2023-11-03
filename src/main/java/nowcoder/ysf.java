package nowcoder;
/*
 牛客题霸-名企高频面试题
环形链表的约瑟夫问题
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：130
 算法知识视频讲解
题目描述
据说著名犹太历史学家 Josephus 有过以下故事：在罗马人占领乔塔帕特后，39 个犹太人与 Josephus 及他的朋友躲到一个洞中，
39 个犹太人决定宁愿死也不要被敌人抓到，于是决定了一种自杀方式，41 个人排成一个圆圈，由第 1 个人开始报数，报数到 3 的人就自杀，
然后再由下一个人重新报 1，报数到 3 的人再自杀，这样依次下去，直到剩下最后一个人时，那个人可以自由选择自己的命运。这就是著名的约瑟夫问题。
现在请用单向环形链表得出最终存活的人的编号。

 n 表示环形链表的长度， m 表示每次报数到 m 就自杀。
示例1
输入
复制
5,2
输出
复制
3
备注:
1 \leq n, m \leq 100001≤n,m≤10000
 */

public class ysf {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            val = this.val;
            this.next = next;
        }
    }

    static public class Solution {
        /**
         * @param n int整型
         * @param m int整型
         * @return int整型
         */
        public int ysf(int n, int m) {
            ListNode head = new ListNode(1);
            ListNode p = head;
            for (int i = 2; i <= n; i++) {
                p.next = new ListNode(i);
                p = p.next;
            }
            p.next = head;
            int count = 1;
            while (p.next != p) {
                if (count == m) {
                    count = 1;
                    p.next = p.next.next;
                } else {
                    p = p.next;
                    count++;
                }
            }
            return p.val;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 2;
        System.out.println(new Solution().ysf(n, m));
    }
}
