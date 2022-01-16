package Beijing;
/*
https://leetcode-cn.com/problems/linked-list-random-node/
 */


import java.util.Random;

public class LinkedListRandomNode {

    // 自己没看明白这个证明
    static class Solution {
        ListNode head;
        Random random;

        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        public int getRandom() {
            ListNode ans = new ListNode(0), p = head;
            int count = 1;
            while (p != null) {
                if (random.nextInt(count) == 0) {
                    ans = p;
                }
                p = p.next;
                count++;
            }
            return ans.val;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(head);
     * int param_1 = obj.getRandom();
     */

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3};
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int i = 0; i < nodes.length; i++) {
            p.next = new ListNode(nodes[i]);
            p = p.next;
        }
        head = head.next;
        Solution obj = new Solution(head);
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
    }
}

