package LeetCode.ProgrammerInterview;
/*
面试题 02.06. 回文链表
编写一个函数，检查输入的链表是否是回文的。



示例 1：

输入： 1->2
输出： false
示例 2：

输入： 1->2->2->1
输出： true


进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

通过次数3,184提交次数6,389
 */

//自己没想到这样写，但是这个真的很厉害
public class isPalindrome {
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head, fast = head;
            while (slow != null && fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode per = null, tmp = null;
            while (slow != null) {
                tmp = slow.next;
                slow.next = per;
                per = slow;
                slow = tmp;
            }
            while (head != null && per != null) {
                if (head.val != per.val) {
                    return false;
                }
                head = head.next;
                per = per.next;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2};
        ListNode per = new ListNode(-1), p = per;
        for (int i = 0; i < nodes.length; i++) {
            p.next = new ListNode(nodes[i]);
            p = p.next;
        }
        System.out.println(new Solution().isPalindrome(per.next));
    }
}
