package beijing;

/**
 * @author zhouhao
 * @date 2023/10/24 20:05
 */
public class DeleteDuplicates_83 {
    static class Solution {
        // 面试中这题我居然没写出来
        public ListNode deleteDuplicates(ListNode head) {
            ListNode p = head;
            while (p != null && p.next != null) {
                if (p.val == p.next.val) {
                    p.next = p.next.next;
                } else {
                    p = p.next;
                }
            }
            return head;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 1, 2, 3, 3};
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        ListNode ans = new Solution().deleteDuplicates(dummyHead.next);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
