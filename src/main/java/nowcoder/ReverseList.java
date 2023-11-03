package nowcoder;
/*
题目描述
输入一个链表，反转链表后，输出新链表的表头。
 */

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode after = reverseList(head.next);
        next.next = head;
        head.next = null;
        return after;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        p = new ReverseList().reverseList(perhead.next);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}
