package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：56163
本题知识点： 链表 双指针
 算法知识视频讲解
题目描述
对于一个给定的链表，返回环的入口节点，如果没有环，返回null
拓展：
你能给出不利用额外空间的解法么？
 */

public class detectCycle {
    static public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode faster = head, slower = head;
            boolean flag = false;
            while (faster != null && faster.next != null && slower != null) {
                faster = !flag ? faster.next.next : faster.next;
                slower = slower.next;
                if (faster == slower) {
                    if (flag) {
                        return faster;
                    } else {
                        slower = head;
                        flag = true;
                        if (faster == head) {
                            return faster;
                        }
                    }
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int cyc = 1;
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        ListNode CYC = null;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
            if (num == cyc) {
                CYC = p;
            }
        }
        p.next = CYC;
        System.out.println(new Solution().detectCycle(perhead.next).val);
    }
}
