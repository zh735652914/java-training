package LeetCode;

public class PrintLinkedList {
    public void Print(ListNode head) {
        ListNode p = head;
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
