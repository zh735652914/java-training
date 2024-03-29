package beijing;

public class reverseLinkedList_206 {
    // 第N次了，还是没写出来，要背下来！！
    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return next;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5};
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        ListNode ans = new Solution().reverseList(dummyHead.next);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
