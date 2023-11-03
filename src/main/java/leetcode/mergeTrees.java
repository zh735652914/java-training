package leetcode;
/*
617. 合并二叉树
给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

示例 1:

输入:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
输出:
合并后的树:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7
注意: 合并必须从两个树的根节点开始。

通过次数71,091提交次数92,048
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class mergeTrees {
    static class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            }
            TreeNode node = null;
            if (t1 != null && t2 != null) {
                node = new TreeNode(t1.val + t2.val);
                node.left = mergeTrees(t1.left, t2.left);
                node.right = mergeTrees(t1.right, t2.right);
                return node;
            }
            if (t1 == null) {
                node = new TreeNode(t2.val);
                node.left = mergeTrees(null, t2.left);
                node.right = mergeTrees(null, t2.right);
                return node;
            } else {
                node = new TreeNode(t1.val);
                node.left = mergeTrees(t1.left, null);
                node.right = mergeTrees(t1.right, null);
                return node;
            }
        }
    }

    static class buildTree {
        public TreeNode deserialize(String data) {
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
    }

    static class outputTree {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<String> list = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode tmp = queue.poll();
                list.add(makeString(tmp));
                if (tmp != null) {
                    queue.offer(tmp.left);
                    queue.offer(tmp.right);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (String s : list) {
                stringBuilder.append(s);
                stringBuilder.append(",");
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        private String makeString(TreeNode root) {
            if (root == null) {
                return "null";
            } else {
                return String.valueOf(root.val);
            }
        }
    }

    public static void main(String[] args) {
        String nodes1 = "[1,3,2,5]";
        String nodes2 = "[2,1,3,null,4,null,7]";
        TreeNode t1 = new buildTree().deserialize(nodes1);
        TreeNode t2 = new buildTree().deserialize(nodes2);
        TreeNode root = new Solution().mergeTrees(t1, t2);
        System.out.println(new outputTree().serialize(root));
    }
}
