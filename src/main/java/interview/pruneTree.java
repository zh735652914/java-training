package interview;
/*
814. 二叉树剪枝
给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。

返回移除了所有不包含 1 的子树的原二叉树。

( 节点 X 的子树为 X 本身，以及所有 X 的后代。)

示例1:
输入: [1,null,0,0,1]
输出: [1,null,0,null,1]

解释:
只有红色节点满足条件“所有不包含 1 的子树”。
右图为返回的答案。


示例2:
输入: [1,0,1,0,0,0,1]
输出: [1,null,1,null,1]



示例3:
输入: [1,1,0,1,1,0,1,0]
输出: [1,1,0,1,1,null,1]



说明:

给定的二叉树最多有 100 个节点。
每个节点的值只会为 0 或 1 。
通过次数11,661提交次数15,978
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pruneTree {
    static class Solution {
        public TreeNode pruneTree(TreeNode root) {
            if (!hasOne(root)) {
                return null;
            }
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            return root;
        }

        private boolean hasOne(TreeNode root) {
            if (root == null) {
                return false;
            }
            if (root.val == 1) {
                return true;
            }
            return hasOne(root.left) || hasOne(root.right);
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
        String nodes = "[1,1,0,1,1,0,1,0]";
        TreeNode root = new buildTree().deserialize(nodes);
        TreeNode after = new Solution().pruneTree(root);
        System.out.println(new outputTree().serialize(after));
    }
}
