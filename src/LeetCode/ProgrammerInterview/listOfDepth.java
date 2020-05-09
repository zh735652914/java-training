package LeetCode.ProgrammerInterview;
/*
面试题 04.03. 特定深度节点链表
给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。
返回一个包含所有深度的链表的数组。



示例：

输入：[1,2,3,4,5,null,7,8]

        1
       /  \
      2    3
     / \    \
    4   5    7
   /
  8

输出：[[1],[2,3],[4,5,7],[8]]
通过次数2,854提交次数3,533
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class listOfDepth {
    static class Solution {
        List<ListNode> list;
        Queue<TreeNode> queue;

        public ListNode[] listOfDepth(TreeNode tree) {
            list = new LinkedList<>();
            queue = new LinkedList<>();
            if (tree == null) {
                return null;
            }
            queue.add(tree);
            backtrack();
            ListNode[] ans = new ListNode[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;
//            return (ListNode[]) list.toArray();
        }

        private void backtrack() {
            int n = queue.size();
            if (n == 0) return;
            ListNode per = new ListNode(-1);
            ListNode p = per;
            while (n > 0) {
                TreeNode node = queue.remove();
                p.next = new ListNode(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                p = p.next;
                n--;
            }
            list.add(per.next);
            backtrack();
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "2", "3", "4", "5", "null", "7", "8"};
        TreeNode root = new BuildTree().level_build_tree(nodes);
        ListNode[] ans = new Solution().listOfDepth(root);
    }

}
