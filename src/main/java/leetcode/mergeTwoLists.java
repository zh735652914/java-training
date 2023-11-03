package leetcode;

/*
https://leetcode-cn.com/problems/merge-two-sorted-lists/
21. 合并两个有序链表
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。



示例 1：


输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
示例 2：

输入：l1 = [], l2 = []
输出：[]
示例 3：

输入：l1 = [], l2 = [0]
输出：[0]


提示：

两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列
 */
public class mergeTwoLists {
    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode per = new ListNode(-1);
            ListNode p = per;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p.next.next = null;
                p = p.next;
            }
            if (l1 != null) {
                p.next = l1;
            } else {
                p.next = l2;
            }
            return per.next;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {1, 3, 4};
        ListNode per = new ListNode(-1);
        ListNode p = per;
        for (int i = 0; i < nums1.length; i++) {
            p.next = new ListNode(nums1[i]);
            p = p.next;
        }
        ListNode l1 = per.next;
        p = per;
        for (int i = 0; i < nums2.length; i++) {
            p.next = new ListNode(nums2[i]);
            p = p.next;
        }
        ListNode l2 = per.next;
        ListNode ans = new Solution().mergeTwoLists(l1, l2);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
