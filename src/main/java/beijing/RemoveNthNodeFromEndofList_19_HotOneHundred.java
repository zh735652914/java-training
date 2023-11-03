package beijing;
/*
https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */

/**
 * @author zhouhao
 * @date 2023/4/4 12:45
 */
public class RemoveNthNodeFromEndofList_19_HotOneHundred {
    // 很简单的中等题
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode faster = dummyHead, slower = dummyHead;
            while (n-- > 0) {
                faster = faster.next;
            }
            while (faster.next != null) {
                faster = faster.next;
                slower = slower.next;
            }
            slower.next = slower.next.next;
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5};
        int n = 5;
        ListNode head = mkList(nodes);
        ListNode ans = new Solution().removeNthFromEnd(head, n);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }

    private static ListNode mkList(int[] nodes) {
        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        return dummyNode.next;
    }
}
