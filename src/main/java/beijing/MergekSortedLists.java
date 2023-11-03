package beijing;
/*
https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */

import java.util.PriorityQueue;

public class MergekSortedLists {
    // 优先队列的方式我没想到
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));
            for (ListNode list : lists) {
                while (list != null) {
                    priorityQueue.offer(list);
                    list = list.next;
                }
            }
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
            while (!priorityQueue.isEmpty()) {
                p.next = priorityQueue.poll();
                p = p.next;
            }
            p.next = null;
            return dummyHead.next;
        }
    }

    // 自己写的效率好像不高啊
    static class Solution0 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 1 && lists[0] == null) {
                return null;
            }
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
            while (true) {
                boolean flagTail = true;
                ListNode cur = null;
                int move = -1;
                for (int i = 0; i < lists.length; i++) {
                    if (lists[i] != null) {
                        flagTail = false;
                    } else {
                        continue;
                    }
                    if (cur == null) {
                        cur = lists[i];
                        move = i;
                    } else {
                        if (cur.val > lists[i].val) {
                            cur = lists[i];
                            move = i;
                        }
                    }
                }
                if (flagTail) {
                    break;
                }
                lists[move] = lists[move].next;
                p.next = cur;
                p = p.next;
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] lists = new ListNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
            for (int num : nums[i]) {
                p.next = new ListNode(num);
                p = p.next;
            }
            lists[i] = dummyHead.next;
        }
        ListNode ans = new Solution().mergeKLists(lists);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }
}
