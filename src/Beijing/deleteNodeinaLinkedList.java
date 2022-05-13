package Beijing;
/*
https://leetcode.cn/problems/delete-node-in-a-linked-list/
 */

// 脑筋急转弯
public class deleteNodeinaLinkedList {
    static class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 9};
        int nodes = 5;
        ListNode node = null;
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int num : nums) {
            ListNode cur = new ListNode(num);
            p.next = cur;
            if (num == nodes) {
                node = cur;
            }
            p = p.next;
        }
        new Solution().deleteNode(node);
        p = dummyHead.next;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
