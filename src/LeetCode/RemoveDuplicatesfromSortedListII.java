package LeetCode;

import javax.naming.ldap.Rdn;

/*
Share
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
 */
class RemoveDuplicatesfromSortedListIISolution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = head, pos = ans, next = ans, per = ans;
        if (head == null) return head;
        ListNode Perhead = new ListNode(ans.val);
        int flag = 0, last = Integer.MIN_VALUE;
        while (pos != null) {
            if (flag == 1) {
                if (ans.next == null && Perhead.val == ans.val) return ans.next;
                if (Perhead.val == ans.val) {
                    ans = ans.next;
                    per = ans;
                    pos = per;
                    continue;
                } else {
                    Perhead.val = ans.val;
                    flag = 0;
                }
            }
            if (ans.next != null && Perhead.val == ans.next.val) {
                ans = ans.next.next;
                per = ans;
                pos = per;
                flag = 1;
                continue;
            }
            next = pos.next;

//            if (next == null) break;
            if ((next != null && pos.val == next.val) || last == pos.val) {
                if (next == null) {
                    per.next = next;
                    break;
                }
                last = pos.val;
                pos = next;
                per.next = pos;
            } else {
                per = pos;
                pos = next;
            }
        }
        return ans;
    }
}

public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2};
//        int[] nums = {1, 1, 1, 2, 3, 4, 4, 5, 5, 5};
        ListNode head = new ListNode(1), per = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode p = new ListNode(nums[i]);
            per.next = p;
            per = p;
        }
        RemoveDuplicatesfromSortedListIISolution RDSL = new RemoveDuplicatesfromSortedListIISolution();
        ListNode ans = RDSL.deleteDuplicates(head);
//        ListNode ans = head;
        if (ans == null) System.out.println("The ans is null!");
        while (ans != null) {
            if (ans.next == null) {
                System.out.print(ans.val);
                break;
            }
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
