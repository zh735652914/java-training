package LeetCode;
/*
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */
//自己不会写，看了discuss后写的

class SortListSolution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head, pre = slow;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode prehead = new ListNode(-1), p = prehead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        while (left != null) {
            p.next = left;
            left = left.next;
            p = p.next;
        }
        while (right != null) {
            p.next = right;
            right = right.next;
            p = p.next;
        }
        return prehead.next;
    }
}

public class SortList {
    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 3};
        ListNode head = new ListNode(nums[0]), p = head;
        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        p = head;
        System.out.println("原链表为：");
        while (p != null) {
            if (p.next == null) {
                System.out.println(p.val);
                break;
            }
            System.out.print(p.val + "->");
            p = p.next;
        }
        SortListSolution sortListSolution = new SortListSolution();
        ListNode ans = sortListSolution.sortList(head);
        p = ans;
        System.out.println("排序后链表为：");
        while (p != null) {
            if (p.next == null) {
                System.out.println(p.val);
                break;
            }
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
