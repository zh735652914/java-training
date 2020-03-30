package LeetCode.ProgrammerInterview;
/*
面试题 02.01. 移除重复节点
编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

示例1:

 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
示例2:

 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]
提示：

链表长度在[0, 20000]范围内。
链表元素在[0, 20000]范围内。
进阶：

如果不得使用临时缓冲区，该怎么解决？

通过次数3,819提交次数5,789
 */

import java.util.HashSet;
import java.util.Set;

public class removeDuplicateNodes {
    static class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {
            Set<Integer> hashset = new HashSet<>();
            ListNode faster = head, slow = new ListNode(-1);
            slow.next = faster;
            while (faster != null) {
                if (!hashset.contains(faster.val)) {
                    hashset.add(faster.val);
                    faster = faster.next;
                    slow = slow.next;
                } else {
                    slow.next = faster.next;
                    faster = faster.next;
                }
            }
            return head;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 2, 1};
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        p = new Solution().removeDuplicateNodes(perhead.next);
        while (p != null) {
            System.out.print(p.val + ",");
            p = p.next;
        }
        System.out.println();
    }
}
