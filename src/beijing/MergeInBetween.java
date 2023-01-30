package beijing;
/*
https://leetcode.cn/problems/merge-in-between-linked-lists/
 */

/**
 * @author zhouhao
 * @date 2023/1/30 12:46
 */
public class MergeInBetween {
    static class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            ListNode end2 = list2;
            while (end2.next != null) {
                end2 = end2.next;
            }
            int count = 0;
            ListNode p = list1, left = list1, right = list1;
            while (p != null) {
                if (a - 1 == count) {
                    left = p;
                } else if (b + 1 == count) {
                    right = p;
                }
                p = p.next;
                count++;
            }
            left.next = list2;
            end2.next = right;
            return list1;
        }
    }

    public static void main(String[] args) {
        int[] nodes1 = {0, 1, 2, 3, 4, 5};
        int[] nodes2 = {1000000, 1000001, 1000002};
        int a = 3, b = 4;
        ListNode list1 = mkList(nodes1);
        ListNode list2 = mkList(nodes2);
        ListNode ans = new Solution().mergeInBetween(list1, a, b, list2);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }

    private static ListNode mkList(int[] nodes) {
        ListNode dummyHead = new ListNode(-1), p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        return dummyHead.next;
    }
}
