package LeetCode;
/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
 */

class PartitionListSolution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode ans = head, pos = ans, last = ans, per = ans;
        boolean after = false, bighead = false;
        if (head.val >= x) {
            bighead = true;
            after = true;
        }
        while (pos != null) {
            if (bighead) {
                if (pos.val >= x) {
                    per = pos;
                    last = pos;
                    pos = pos.next;
                } else {
                    ListNode Pans = ans;
                    per.next = pos.next;
                    ans = pos;
                    last = ans;
                    ans.next = Pans;
                    pos = per.next;
                    bighead = false;
                }
            } else {
                if (after) {
                    if (pos.val < x) {
                        per.next = pos.next;
                        pos.next = last.next;
                        last.next = pos;
                        last = pos;
                        pos = per.next;
                    } else {
                        per = pos;
                        pos = pos.next;
                    }
                } else {
                    if (pos.val < x) {
                        last = pos;
                        per = pos;
                        pos = pos.next;
                    } else {
                        per = pos;
                        pos = pos.next;
                        after = true;
                    }
                }
            }
        }
        return ans;
    }
}

public class PartitionList {
    public static void main(String[] args) {
//        int[] nums = {1, 4, 3, 2, 5, 2};
//        int[] nums = {4, 6, 1, 3, 2, 5, 2};
        int[] nums = {1, 3, -1, 5, 2, 1};
        int x = 3;
        ListNode head = null;
        if (nums.length > 0) {
            head = new ListNode(nums[0]);
        }
        ListNode p = head;
        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        p = head;
        System.out.print("原链表为： ");
        while (p != null) {
            if (p.next == null) {
                System.out.println(p.val);
                break;
            }
            System.out.print(p.val + "->");
            p = p.next;
        }
        PartitionListSolution PL = new PartitionListSolution();
        ListNode ans = PL.partition(head, x);
        while (ans != null) {
            if (ans.next == null) {
                System.out.println(ans.val);
                break;
            }
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
