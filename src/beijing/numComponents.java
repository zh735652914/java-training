package beijing;
/*
https://leetcode.cn/problems/linked-list-components/
 */

import java.util.HashSet;
import java.util.Set;

// 自己写的效率不高
public class numComponents {
    static class Solution {
        public int numComponents(ListNode head, int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            ListNode p = head;
            int count = 0;
            while (p != null) {
                if (set.contains(p.val)) {
                    count++;
                    while (p != null && set.contains(p.val)) {
                        set.remove(p.val);
                        p = p.next;
                    }
                }
                if (p == null) {
                    break;
                }
                p = p.next;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {0, 1, 2, 3, 4};
        int[] nums = {0, 3, 1, 4};
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        System.out.println(new Solution().numComponents(dummyHead.next, nums));
    }
}
