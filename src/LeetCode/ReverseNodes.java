package LeetCode;

/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
*/


import java.util.HashMap;


//class SolutionReverseNodes {
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode m = head;
//        ListNode n = head;
//        for (int i = 0; i < k; i++) {
//            n = n.next;
//        }
//        int flag = 1;
//        while (n != null) {
//            ListNode curr0 = m;
//            ListNode curr1 = n;
//            ListNode tmp = Reverse();
//        }
//    }
//
//    public HashMap<String, ListNode> Reverse(ListNode head, int k) {
//        HashMap hash = new HashMap();
//        if (k == 1) {
//            hash.put("L", head);
//            hash.put("R", head);
//            return hash;
//        } else if (k == 2) {
//            ListNode tail = head.next;
//            ListNode tmp = tail.next;
//            tail.next = head;
//            head.next = tmp;
//            hash.put("L", tail);
//            hash.put("R", head);
//            return hash;
//        } else {
//            hash.put("L", Reverse().get("L"));
//        }
//    }
//}

public class ReverseNodes {
//    public static void main(String[] args) {
//        int k = 2;
//        int[] nums = {1, 2, 3, 4, 5};
//        ListNode head = new ListNode(nums[0]);
//        ListNode pre = head;
//        for (int i = 1; i < nums.length; i++) {
//            ListNode p = new ListNode(nums[i]);
//            pre.next = p;
//            pre = p;
//        }
//        SolutionReverseNodes SRN = new SolutionReverseNodes();
//        ListNode ans = SRN.reverseKGroup(head, k);
////        ListNode ans = head;
//        while (ans != null) {
//            if (ans.next == null) {
//                System.out.print(ans.val);
//                break;
//            }
//            System.out.print(ans.val + "->");
//            ans = ans.next;
//        }
//    }
}
