package LeetCode;

/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
 */
class ReverseLinkedListIISolution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode begin = head, p = head, per = head, pbegin = head, next = head;
        int pos = 1;
        if (m == n) return head;
        while (p != null) {
            if (pos == m) {
                pbegin = per;
                begin = p;
                per = p;
                p = p.next;
                pos++;
                continue;
            }
            if (pos > m && pos < n) {
                next = p.next;
                p.next = per;
                per = p;
                p = next;
                pos++;
                continue;
            }
            if (pos == n) {
//                end = p;
                next = p.next;
                p.next = per;
                break;
            }
            per = p;
            p = p.next;
            pos++;
        }
        pbegin.next = p;
        begin.next = next;
        if (m == 1) head = p;
        return head;
    }
}

public class ReverseLinkedListII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int[] nums = {5};
        int m = 5, n = 7;
        BuildLinkedList BD = new BuildLinkedList();
        ListNode head = BD.Build(nums);
        PrintLinkedList PLL = new PrintLinkedList();
        System.out.println("原链表为：");
        PLL.Print(head);
        ReverseLinkedListIISolution RLLII = new ReverseLinkedListIISolution();
        ListNode ans = RLLII.reverseBetween(head, m, n);
        System.out.println("翻转后链表为：");
        PLL.Print(ans);
    }
}
