package Beijing;

// 这题虽然是脑筋急转弯，但是自己还是没写出来
public class deleteNodeinaLinkedList_237 {
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
