package beijing;
/*
https://leetcode-cn.com/problems/add-two-numbers/
 */

public class addTwoNumbers {
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode NewHead = new ListNode(-1);
            ListNode p = l1, q = l2, r = NewHead;
            int sum = 0, carry = 0;
            while (p != null && q != null) {
                sum = p.val + q.val + carry;
                r.next = new ListNode(sum % 10);
                carry = sum / 10;
                p = p.next;
                q = q.next;
                r = r.next;
            }
            while (p != null) {
                sum = p.val + carry;
                r.next = new ListNode(sum % 10);
                carry = sum / 10;
                p = p.next;
                r = r.next;
            }
            while (q != null) {
                sum = q.val + carry;
                r.next = new ListNode(sum % 10);
                carry = sum / 10;
                q = q.next;
                r = r.next;
            }
            while (carry > 0) {
                r.next = new ListNode(carry % 10);
                carry /= 10;
            }
            return NewHead.next;
        }
    }

    public static void main(String[] args) {
        int[] l1 = {2, 4, 3}, l2 = {5, 6, 4};
        ListNode p = MkList(l1);
        ListNode q = MkList(l2);
        ListNode ans = new Solution().addTwoNumbers(p, q);
        while (ans != null) {
            System.out.print(ans.val + ", ");
            ans = ans.next;
        }
    }

    private static ListNode MkList(int[] nums) {
        ListNode per = new ListNode(-1);
        ListNode p = per;
        for (int i = 0; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return per.next;
    }
}
