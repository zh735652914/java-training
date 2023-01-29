package beijing;
/*
https://leetcode.cn/problems/rotate-list/
 */

// 数学逻辑需要
public class rotateList_61 {
    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return head;
            }
            ListNode tail = head;
            int count = 1;
            while (tail.next != null) {
                tail = tail.next;
                count++;
            }
            tail.next = head;
            k = k % count;
            k = count - k;
            while (k-- > 0) {
                tail = tail.next;
            }
            head = tail.next;
            tail.next = null;
            return head;
        }
    }

    public static void main(String[] args) {
//        int[] nodes = {1, 2, 3, 4, 5};
//        int k = 2;
        int[] nodes = {0, 1, 2};
        int k = 4;
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        ListNode ans = new Solution().rotateRight(dummyHead.next, k);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
