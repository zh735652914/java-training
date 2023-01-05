package Beijing;
/*
https://leetcode.cn/problems/odd-even-linked-list/
 */

/**
 * @author zhouhao
 * @date 2023/1/5 12:46
 */
public class OddEvenLinkedList_328_topInterviewList {
    // 的确不难
    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            ListNode oddDummyHead = new ListNode(-1);
            ListNode evenDummyHead = new ListNode(-1);
            ListNode p = oddDummyHead, q = evenDummyHead;
            boolean oddFlag = true;
            while (head != null) {
                if (oddFlag) {
                    p.next = head;
                    p = p.next;
                } else {
                    q.next = head;
                    q = q.next;
                }
                oddFlag = !oddFlag;
                head = head.next;
            }
            p.next = evenDummyHead.next;
            q.next = null;
            return oddDummyHead.next;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {2, 1, 3, 5, 6, 4, 7};
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        ListNode ans = new Solution().oddEvenList(dummyHead.next);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
