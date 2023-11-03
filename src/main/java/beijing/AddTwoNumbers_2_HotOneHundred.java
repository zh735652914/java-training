package beijing;
/*
https://leetcode.cn/problems/add-two-numbers/
 */

/**
 * @author zhouhao
 * @date 2023/3/4 13:09
 */
public class AddTwoNumbers_2_HotOneHundred {
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
            while (l1 != null && l2 != null) {
                int x = l1.val + l2.val + carry;
                carry = x / 10;
                x %= 10;
                p.next = new ListNode(x);
                p = p.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                int x = carry + l1.val;
                carry = x / 10;
                x %= 10;
                p.next = new ListNode(x);
                p = p.next;
                l1 = l1.next;
            }
            while (l2 != null) {
                int x = carry + l2.val;
                carry = x / 10;
                x %= 10;
                p.next = new ListNode(x);
                p = p.next;
                l2 = l2.next;
            }
            while (carry != 0) {
                p.next = new ListNode(carry % 10);
                carry /= 10;
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        int[] nodes1 = {2, 4, 3}, nodes2 = {5, 6, 4};
        ListNode l1 = mkList(nodes1);
        ListNode l2 = mkList(nodes2);
        ListNode ans = new Solution().addTwoNumbers(l1, l2);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }

    private static ListNode mkList(int[] nodes) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        return dummyHead.next;
    }
}
