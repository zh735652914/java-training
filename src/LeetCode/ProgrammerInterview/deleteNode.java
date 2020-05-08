package LeetCode.ProgrammerInterview;
/*
面试题 02.03. 删除中间节点
实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。



示例：

输入：单向链表a->b->c->d->e->f中的节点c
结果：不返回任何数据，但该链表变为a->b->d->e->f
通过次数4,766提交次数6,051
 */

public class deleteNode {
    static class Solution {
        public void deleteNode(ListNode node, ListNode head) {
            ListNode p = node.next;
            node.val = p.val;
            node.next = p.next;
        }
    }

//    public static void main(String[] args) {
//        int[] nodes = {4, 5, 1, 9};
//        int x = 5;
//        ListNode node = null, per = new ListNode(-1), p = per;
//        for (int i = 0; i < nodes.length; i++) {
//            if (nodes[i] == x) {
//                node = new ListNode(x);
//                p.next = node;
//                p = p.next;
//            } else {
//                p.next = new ListNode(nodes[i]);
//                p = p.next;
//            }
//        }
//        new Solution().deleteNode(node, per.next);
//    }
}
