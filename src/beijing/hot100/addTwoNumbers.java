package beijing.hot100;
/*
https://leetcode.cn/problems/add-two-numbers/
 */

public class addTwoNumbers {
    // 不难，就是要细心点
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
            int carry = 0, sum = 0;
            while (l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
                carry = sum / 10;
                p.next = new ListNode(sum % 10);
                p = p.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                sum = l1.val + carry;
                carry = sum / 10;
                p.next = new ListNode(sum % 10);
                p = p.next;
                l1 = l1.next;
                if (carry == 0) {
                    p.next = l1;
                    break;
                }
            }
            while (l2 != null) {
                sum = l2.val + carry;
                carry = sum / 10;
                p.next = new ListNode(sum % 10);
                p = p.next;
                l2 = l2.next;
                if (carry == 0) {
                    p.next = l2;
                    break;
                }
            }
            while (carry != 0) {
                p.next = new ListNode(carry % 10);
                carry /= 10;
                p = p.next;
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 3}, nums2 = {5, 6, 4};
        ListNode l1 = mkList(nums1);
        ListNode l2 = mkList(nums2);
        ListNode ans = new Solution().addTwoNumbers(l1, l2);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }

    private static ListNode mkList(int[] nums) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        return dummyHead.next;
    }
}
