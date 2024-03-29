package leetcode;
/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Note: Do not modify the linked list.



Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.


Example 2:

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.


Example 3:

Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.




Follow-up:
Can you solve it without using extra space?
 */


import java.util.ArrayList;
import java.util.List;

class LinkedListCycleIISolution {
    public ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode p = head, ans = null;
        while (p != null) {
            if (list.contains(p)) {
                ans = p;
                break;
            }
            list.add(p);
            p = p.next;
        }
        return ans;
    }
}

public class LinkedListCycleII {
    public static void main(String[] args) {
        int[] nums = {3, 2, 0, -4};
        int pos = 1;
        ListNode head = new ListNode(nums[0]);
        ListNode p = head, cycle = new ListNode(-999);
        for (int i = 1; i < nums.length; i++) {
            ListNode tmp = new ListNode(nums[i]);
            p.next = tmp;
            p = tmp;
            if (pos == i) cycle = tmp;
        }
        if (pos == 0) cycle = head;
        p.next = cycle;
        LinkedListCycleIISolution linkedListCycleIISolution = new LinkedListCycleIISolution();
        System.out.println(linkedListCycleIISolution.detectCycle(head).val);
    }
}
