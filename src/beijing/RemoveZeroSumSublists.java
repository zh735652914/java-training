package beijing;
/*
https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/6/11 11:49
 */
public class RemoveZeroSumSublists {
    // 前缀和，挺有意思的
    static class Solution {
        public ListNode removeZeroSumSublists(ListNode head) {
            /*
            前缀和，如果a+b+c=a+b+c+d+e
            那么d+e=0
             */
            Map<Integer, ListNode> map = new HashMap<>();
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode node = dummyHead;
            int sum = 0;
            while (node != null) {
                sum += node.val;
                map.put(sum, node);
                node = node.next;
            }
            sum = 0;
            node = dummyHead;
            while (node != null) {
                sum += node.val;
                if (map.containsKey(sum)) {
                    node.next = map.get(sum).next;
                }
                node = node.next;
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, -3, 3, 1};
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        ListNode ans = new Solution().removeZeroSumSublists(dummyHead.next);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
