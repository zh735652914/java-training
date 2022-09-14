package Beijing;
/*
https://leetcode.cn/problems/merge-k-sorted-lists/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 还是要多写写
public class mergekSortedLists_23_topInterviewList {
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length < 1) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }
            List<ListNode> ans = Arrays.asList(lists);
            while (ans.size() > 1) {
                int len = ans.size();
                List<ListNode> next = new ArrayList<>();
                for (int i = 0; i < len - 1; i += 2) {
                    next.add(mergeTwoLists(ans.get(i), ans.get(i + 1)));
                }
                if ((len & 1) == 1) {
                    next.add(ans.get(len - 1));
                }
                ans = next;
            }
            return ans.get(0);
        }

        private ListNode mergeTwoLists(ListNode A, ListNode B) {
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
            while (A != null && B != null) {
                if (A.val <= B.val) {
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
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        int[][] nodes = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] lists = new ListNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            lists[i] = mkList(nodes[i]);
        }
        ListNode ans = new Solution().mergeKLists(lists);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }

    private static ListNode mkList(int[] nodes) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        return dummyHead.next;
    }
}
