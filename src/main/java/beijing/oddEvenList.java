package beijing;
/*
https://leetcode.cn/problems/odd-even-linked-list/
 */

public class oddEvenList {
    // 官方解析的写法更简介
    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode evenHead = head.next;
            ListNode odd = head, even = evenHead;
            while (odd.next != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }
    }

    // 这题不难，自己写的
    static class Solution0 {
        public ListNode oddEvenList(ListNode head) {
            int index = 1;
            ListNode p = head;
            ListNode dummyOdd = new ListNode(-1);
            ListNode dummyEven = new ListNode(-1);
            ListNode odd = dummyOdd, even = dummyEven;
            while (p != null) {
                if ((index & 1) == 1) {
                    odd.next = p;
                    odd = odd.next;
                } else {
                    even.next = p;
                    even = even.next;
                }
                p = p.next;
                index++;
            }
            odd.next = dummyEven.next;
            even.next = null;
            ListNode dummyAns = new ListNode(-1);
            dummyAns.next = dummyOdd.next;
            return dummyAns.next;
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
