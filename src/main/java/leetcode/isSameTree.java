package leetcode;
/*
100. 相同的树
给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1:

输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
示例 2:

输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]

输出: false
示例 3:

输入:       1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

输出: false
通过次数139,586提交次数232,078
 */

import java.util.LinkedList;
import java.util.Queue;

public class isSameTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    private TreeNode deserialize(String data) {
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        if (nodes.length == 0 || nodes[0].equals("null")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int index = 1;
        while (index < nodes.length && !queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            tmp.left = make_node(nodes, index++);
            tmp.right = make_node(nodes, index++);
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
        return root;
    }

    private TreeNode make_node(String[] nodes, int index) {
        TreeNode node = null;
        if (index < nodes.length && !nodes[index].equals("null")) {
            node = new TreeNode(Integer.parseInt(nodes[index]));
        }
        return node;
    }

    public static void main(String[] args) {
        String nodes1 = "[1,2,3]";
        String nodes2 = "[1,2,3]";
        isSameTree isSameTree = new isSameTree();
        TreeNode p = isSameTree.deserialize(nodes1);
        TreeNode q = isSameTree.deserialize(nodes2);
        System.out.println(new Solution().isSameTree(p, q));
    }
}
