package beijing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhouhao
 * @date 2023/4/20 12:42
 */
// 归并排序
public class MergekSortedLists_23_HotOneHundred {
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            Queue<ListNode> remainList = new LinkedList<>(Arrays.asList(lists));
            while (remainList.size() > 1) {
                Queue<ListNode> nextList = new LinkedList<>();
                while (remainList.size() > 1) {
                    nextList.offer(mergeTwoList(remainList.poll(), remainList.poll()));
                }
                if (!remainList.isEmpty()) {
                    nextList.offer(remainList.poll());
                }
                remainList = nextList;
            }
            return remainList.peek();
        }

        private ListNode mergeTwoList(ListNode A, ListNode B) {
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
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
