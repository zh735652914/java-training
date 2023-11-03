package leetcode.tooffer;
/*
面试题52. 两个链表的第一个公共节点
输入两个链表，找出它们的第一个公共节点。

如下面的两个链表：



在节点 c1 开始相交。



示例 1：



输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。


示例 2：



输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。


示例 3：



输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
解释：这两个链表不相交，因此返回 null。


注意：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
通过次数5,069提交次数7,924
 */

import java.util.Stack;

public class getIntersectionNode {
    static public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Stack<ListNode> stackA = new Stack<>();
            Stack<ListNode> stackB = new Stack<>();
            ListNode p = headA;
            while (p != null) {
                stackA.push(p);
                p = p.next;
            }
            p = headB;
            while (p != null) {
                stackB.push(p);
                p = p.next;
            }
            while (!stackA.isEmpty() && !stackB.isEmpty() && stackA.peek() == stackB.peek()) {
                if (stackA.size() == 1) return stackA.pop();
                if (stackB.size() == 1) return stackB.pop();
                stackA.pop();
                stackB.pop();
            }
            if (stackA.isEmpty() || stackB.isEmpty()) return null;
            return stackA.pop().next;
        }
    }

    public static void main(String[] args) {
//        int[] numsA = {4, 1, 8, 4, 5};
//        int[] numsB = {5, 0, 1, 8, 4, 5};
//        int intersectVal = 8;
        int[] numsA = {1};
        int[] numsB = {1};
        int intersectVal = 1;
        ListNode headA = new ListNode(numsA[0]);
        ListNode headB = new ListNode(numsB[0]);
        if (intersectVal == numsB[0]) {
            headB = headA;
        }
        ListNode intersect = null, p = headA;
        for (int i = 1; i < numsA.length; i++) {
            p.next = new ListNode(numsA[i]);
            p = p.next;
            if (numsA[i] == intersectVal) {
                intersect = p;
            }
        }
        p = headB;
        for (int i = 1; i < numsB.length; i++) {
            if (numsB[i] == intersectVal) {
                p.next = intersect;
                break;
            } else {
                p.next = new ListNode(numsB[i]);
                p = p.next;
            }
        }
        System.out.println(new Solution().getIntersectionNode(headA, headB).val);
    }
}
