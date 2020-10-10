package nowcoder;
/*
 牛客题霸-名企高频面试题
划分链表 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：16665
本题知识点： 链表 双指针
 算法知识视频讲解
题目描述
给出一个链表和一个值 ，以 为参照将链表划分成两部分，使所有小于 的节点都位于大于或等于 的节点之前。
两个部分之内的节点之间要保持的原始相对顺序。
例如：
给出 1\to 4 \to 3 \to 2 \to 5 \to 21→4→3→2→5→2 和 \ x = 3 x=3,
返回 1\to 2 \to 2 \to 4 \to 3 \to 51→2→2→4→3→5.
示例1
输入
复制
{1,1},0
输出
复制
{1,1}
说明：本题目包含复杂数据结构ListNode，点此查看相关
 */

public class NC23 {
    static public class Solution {
        /**
         * @param head ListNode类
         * @param x    int整型
         * @return ListNode类
         */
        public ListNode partition(ListNode head, int x) {
            ListNode perMin = new ListNode(-1);
            ListNode perMax = new ListNode(-1);
            ListNode p = head, min = perMin, max = perMax;
            while (p != null) {
                if (p.val < x) {
                    min.next = p;
                    min = min.next;
                } else {
                    max.next = p;
                    max = max.next;
                }
                p = p.next;
            }
            max.next = null;
            min.next = perMax.next;
            return perMin.next;
        }
    }

    static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5, 2};
        int x = 3;
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        p = new Solution().partition(perhead.next, x);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
