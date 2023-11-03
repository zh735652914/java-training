package leetcode;
/*
https://leetcode-cn.com/problems/swap-nodes-in-pairs/
24. 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]


提示：

链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100


进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）

通过次数241,047提交次数347,311
 */

public class swapPairs {
    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode per = new ListNode(-1);
            per.next = head;
            ListNode p = per.next;
            ListNode nextNode = null, last = per;
            while (p != null && p.next != null) {
                nextNode = p.next.next;
                last.next = last.next.next;
                p.next.next = p;
                p.next = nextNode;
                last = p;
                p = last.next;
            }
            return per.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode per = new ListNode(-1);
        ListNode p = per;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        ListNode ans = new Solution().swapPairs(per.next);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
