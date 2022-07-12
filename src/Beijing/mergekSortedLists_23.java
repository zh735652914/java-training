package Beijing;
/*
https://leetcode.cn/problems/merge-k-sorted-lists/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 相当于是归并排序
public class mergekSortedLists_23 {
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length < 1) {
                return null;
            }
            List<ListNode> all = Arrays.asList(lists);
            while (all.size() > 1) {
                int size = all.size();
                List<ListNode> next = new ArrayList<>();
                for (int i = 0; i < size - 1; i += 2) {
                    next.add(new mergeTwoSortedLists_21.Solution().mergeTwoLists(all.get(i), all.get(i + 1)));
                }
                if ((size & 1) == 1) {
                    next.add(all.get(size - 1));
                }
                all = next;
            }
            return all.get(0);
        }
    }

    public static void main(String[] args) {
        int[] nodes1 = {1, 4, 5};
        int[] nodes2 = {1, 3, 4};
        int[] nodes3 = {2, 6};
        ListNode[] lists = new ListNode[3];
        lists[0] = mkList(nodes1);
        lists[1] = mkList(nodes2);
        lists[2] = mkList(nodes3);
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
