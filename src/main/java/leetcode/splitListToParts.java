package leetcode;
/*
725. 分隔链表
给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。

每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。

这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。

返回一个符合上述规则的链表的列表。

举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]

示例 1：

输入:
root = [1, 2, 3], k = 5
输出: [[1],[2],[3],[],[]]
解释:
输入输出各部分都应该是链表，而不是数组。
例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
示例 2：

输入:
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
解释:
输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。


提示:

root 的长度范围： [0, 1000].
输入的每个节点的大小范围：[0, 999].
k 的取值范围： [1, 50].


通过次数12,895提交次数23,257
 */

public class splitListToParts {
    static class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            ListNode[] ans = new ListNode[k];
            ListNode p = root;
            int len = 0;
            while (p != null) {
                p = p.next;
                len++;
            }
            int size = Math.max(len / k, 1);
            int left = Math.max((len - size * k), 0);
            int count = 0;
            p = root;
            ListNode last = null;
            while (count < k) {
                ans[count++] = p;
                for (int i = 1; i < size && p != null; i++) {
                    p = p.next;
                }
                if (left > 0) {
                    p = p.next;
                    left--;
                }
                if (last != null) {
                    last.next = null;
                }
                last = p;
                if (p != null) {
                    p = p.next;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        ListNode[] ans = new Solution().splitListToParts(perhead.next, k);
        for (ListNode an : ans) {
            p = an;
            if (p == null) {
                System.out.print("null");
            } else {
                while (p != null) {
                    System.out.print(p.val + ",");
                    p = p.next;
                }
            }
            System.out.println();
        }
    }
}
