package Beijing;
/*
https://leetcode.cn/problems/delete-node-in-a-linked-list/
 */

public class DeleteNodeinaLinkedList_237_topInterviewList {
    // 脑筋急转弯
    static class Solution {
        private ListNode head;

        public void setHead(ListNode head) {
            this.head = head;
        }

        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {4, 5, 1, 9};
        int val = 5;
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        ListNode node = null;
        for (int num : nodes) {
            p.next = new ListNode(num);
            if (num == val) {
                node = p.next;
            }
            p = p.next;
        }
        Solution solution = new Solution();
        solution.setHead(dummyHead.next);
        solution.deleteNode(node);
        p = dummyHead.next;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
