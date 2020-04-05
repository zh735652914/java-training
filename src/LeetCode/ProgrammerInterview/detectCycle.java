package LeetCode.ProgrammerInterview;
/*
面试题 02.08. 环路检测
给定一个有环链表，实现一个算法返回环路的开头节点。
有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。


示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。

示例 2：

输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。

示例 3：

输入：head = [1], pos = -1
输出：no cycle
解释：链表中没有环。

进阶：
你是否可以不用额外空间解决此题？

通过次数1,747提交次数3,415
 */

//依旧感觉自己是个智障。。。
public class detectCycle {
    static public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) return null;
            ListNode fast = head, slow = head;
            while (fast != null && slow != null) {
                if (fast.next == null) return null;
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    fast = head;
                    while (fast != slow) {
                        fast = fast.next;
                        slow = slow.next;
                    }
                    break;
                }
            }
            return fast;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {3, 2, 0, -4};
        int pos = 1;
        ListNode per = new ListNode(-1), p = per, cycle = null;
        for (int i = 0; i < nodes.length; i++) {
            p.next = new ListNode(nodes[i]);
            p = p.next;
            if (i == pos) {
                cycle = p;
            }
        }
        p.next = cycle;
        ListNode ans = new Solution().detectCycle(per.next);
        System.out.println(ans == null ? "no cycle" : ans.val);
    }
}
