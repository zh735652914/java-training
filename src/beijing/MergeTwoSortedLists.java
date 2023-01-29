package beijing;

public class MergeTwoSortedLists {
    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode per = new ListNode(-1);
            ListNode A = list1, B = list2, p = per;
            while (A != null && B != null) {
                if (A.val < B.val) {
                    p.next = A;
                    A = A.next;
                } else {
                    p.next = B;
                    B = B.next;
                }
                p = p.next;
            }
            if (A != null) {
                p.next = A;
            }
            if (B != null) {
                p.next = B;
            }
            return per.next;
        }
    }

    public static void main(String[] args) {
        int[] list1 = {1, 2, 4};
        int[] list2 = {1, 3, 4};

        ListNode A = mkList(list1);
        ListNode B = mkList(list2);

        ListNode C = new Solution().mergeTwoLists(A, B);
        while (C != null) {
            System.out.print(C.val + ",");
            C = C.next;
        }
    }

    private static ListNode mkList(int[] list) {
        ListNode per = new ListNode(-1);
        ListNode p = per;
        for (int i = 0; i < list.length; i++) {
            p.next = new ListNode(list[i]);
            p = p.next;
        }
        return per.next;
    }
}
