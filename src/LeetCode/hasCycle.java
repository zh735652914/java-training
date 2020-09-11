package LeetCode;
/*
141. 环形链表
给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。



示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。


示例 2：

输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。


示例 3：

输入：head = [1], pos = -1
输出：false
解释：链表中没有环。




进阶：

你能用 O(1)（即，常量）内存解决此问题吗？

通过次数225,562提交次数457,807
 */

public class hasCycle {
    static class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode faster = head, slower = head;
            while (faster != null && faster.next != null) {
                faster = faster.next.next;
                slower = slower.next;
                if (slower == faster) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 0, -4};
        int pos = -1;
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        ListNode cyc = null;
        for (int i = 0; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
            if (i == pos) {
                cyc = p;
            }
        }
        p.next = cyc;
        System.out.println(new Solution().hasCycle(perhead.next));
    }
}
