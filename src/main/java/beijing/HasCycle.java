package beijing;
/*
https://leetcode.cn/problems/linked-list-cycle/
 */

/**
 * @author zhouhao
 * @date 2023/7/29 13:46
 */
public class HasCycle {
    // 很简单
    static public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode faster = head.next, slower = head;
            while (faster != null && faster.next != null && slower != null) {
                if (faster == slower) {
                    return true;
                }
                faster = faster.next.next;
                slower = slower.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {3, 2, 0, -4};
        int pos = 1;
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        ListNode cir = null;
        for (int i = 0; i < nodes.length; i++) {
            p.next = new ListNode(nodes[i]);
            p = p.next;
            if (i == pos) {
                cir = p;
            }
        }
        p.next = cir;
        System.out.println(new Solution().hasCycle(dummyHead.next));
    }
}
