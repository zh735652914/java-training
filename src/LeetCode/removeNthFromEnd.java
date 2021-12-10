package LeetCode;
/*
https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
19. 删除链表的倒数第 N 个结点
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

进阶：你能尝试使用一趟扫描实现吗？



示例 1：


输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]


提示：

链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
通过次数352,642提交次数851,270
 */

public class removeNthFromEnd {
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode per = new ListNode(-1);
            per.next = head;
            ListNode fast = per, slow = per;
            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }
            while (fast != null && slow != null) {
                fast = fast.next;
                slow = slow.next;
            }
            if (slow.next == null) {
                return per.next;
            }
            slow.next = slow.next.next;
            return per.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        ListNode per = new ListNode(-1);
        ListNode p = per;
        for (int i = 0; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        int n = 1;
        ListNode ans = new Solution().removeNthFromEnd(per.next, n);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
