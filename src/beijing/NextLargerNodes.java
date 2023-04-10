package beijing;
/*
https://leetcode.cn/problems/next-greater-node-in-linked-list/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhouhao
 * @date 2023/4/10 12:41
 */
public class NextLargerNodes {
    // 这题需要看看
    static class Solution {
        public int[] nextLargerNodes(ListNode head) {
            Stack<int[]> stack = new Stack<>();
            List<Integer> list = new ArrayList<>();
            ListNode cur = head;
            int index = 0;
            while (cur != null) {
                list.add(0);
                while (!stack.isEmpty() && stack.peek()[0] < cur.val) {
                    list.set(stack.pop()[1], cur.val);
                }
                stack.push(new int[]{cur.val, index++});
                cur = cur.next;
            }
            int[] ans = new int[list.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {2, 7, 4, 3, 5};
        ListNode head = mkList(nodes);
        int[] ans = new Solution().nextLargerNodes(head);
        for (int x : ans) {
            System.out.print(x + ", ");
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
