package LeetCode;
/*
572. 另一个树的子树
给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

示例 1:
给定的树 s:

     3
    / \
   4   5
  / \
 1   2
给定的树 t：

   4
  / \
 1   2
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

示例 2:
给定的树 s：

     3
    / \
   4   5
  / \
 1   2
    /
   0
给定的树 t：

   4
  / \
 1   2
返回 false。

通过次数49,013提交次数104,174
 */


import java.util.LinkedList;
import java.util.Queue;

public class isSubtree {
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
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return false;
            }
            return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        private boolean isSameTree(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            }
            if (s == null || t == null) {
                return false;
            }
            if (s.val != t.val) {
                return false;
            }
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
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
//        String nodes1 = "[3,4,5,1,2]";
//        String nodes2 = "[4,1,2]";
        String nodes1 = "[3,4,5,1,null,2]";
        String nodes2 = "[3,1,2]";
        isSubtree isSubtree = new isSubtree();
        TreeNode s = isSubtree.deserialize(nodes1);
        TreeNode t = isSubtree.deserialize(nodes2);
        System.out.println(new Solution().isSubtree(s, t));
    }
}
