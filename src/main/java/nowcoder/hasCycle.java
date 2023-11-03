package nowcoder;
/*
题目描述
判断给定的链表中是否有环
扩展：
你能给出空间复杂度的解法么？

 */

public class hasCycle {
    public static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode faster = head;
            ListNode slower = head;
            while (faster != null && faster.next != null && slower != null) {
                faster = faster.next.next;
                slower = slower.next;
                if (faster == slower) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        ListNode cyc = p;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
            if (num == 4) {
                cyc = p;
            }
        }
        cyc.next = perhead.next;
        System.out.println(new Solution().hasCycle(perhead.next));
    }
}
