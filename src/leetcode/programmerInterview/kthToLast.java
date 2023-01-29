package leetcode.programmerInterview;
/*
面试题 02.02. 返回倒数第 k 个节点
实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。

注意：本题相对原题稍作改动

示例：

输入： 1->2->3->4->5 和 k = 2
输出： 4
说明：

给定的 k 保证是有效的。

通过次数5,482提交次数6,899
 */

public class kthToLast {
    static class Solution {
        public int kthToLast(ListNode head, int k) {
            ListNode fast = head, slow = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow.val;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5};
        ListNode per = new ListNode(-1), p = per;
        for (int i = 0; i < nodes.length; i++) {
            p.next = new ListNode(nodes[i]);
            p = p.next;
        }
        int k = 2;
        System.out.println(new Solution().kthToLast(per.next, k));
    }
}
