package beijing.hot100;

// 也很简单
public class linkedListCycleII_142 {
    static public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode faster = head, slower = head;
            if (faster.next == null) {
                return null;
            }
            do {
                faster = faster.next.next;
                slower = slower.next;
            } while (faster != null && faster.next != null && faster != slower);
            if (faster == null || faster.next == null) {
                return null;
            }
            ListNode ans = head;
            while (ans != slower) {
                ans = ans.next;
                slower = slower.next;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {3, 2, 0, -4};
        int pos = -1;
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead, cycle = null;
        for (int i = 0; i < nodes.length; i++) {
            ListNode cur = new ListNode(nodes[i]);
            p.next = cur;
            p = p.next;
            if (i == pos) {
                cycle = cur;
            }
        }
        p.next = cycle;
        ListNode ans = new Solution().detectCycle(dummyHead.next);
        System.out.println(ans == null ? -1 : ans.val);
    }
}
