package leetcode;
/*
872. 叶子相似的树
请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。



举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。

如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。

如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。



提示：

给定的两颗树可能会有 1 到 200 个结点。
给定的两颗树上的值介于 0 到 200 之间。
通过次数16,562提交次数26,457
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leafSimilar {
    static class Solution {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
            get_leaf(root1, true);
            get_leaf(root2, false);
            if (queue1.size() != queue2.size()) {
                return false;
            }
            while (!queue1.isEmpty()) {
                if (!queue1.poll().equals(queue2.poll())) {
                    return false;
                }
            }
            return true;
        }

        private void get_leaf(TreeNode root, boolean flag_1) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                if (flag_1) {
                    queue1.offer(root.val);
                } else {
                    queue2.offer(root.val);
                }
            }
            get_leaf(root.left, flag_1);
            get_leaf(root.right, flag_1);
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
        String nodes1 = "[3,5,1,6,2,9,8,null,null,7,4]";
        String nodes2 = "[3,5,2,6,2,9,8,null,null,7,4]";
        TreeNode root1 = new buildTree().deserialize(nodes1);
        TreeNode root2 = new buildTree().deserialize(nodes2);
        System.out.println(new Solution().leafSimilar(root1, root2));
    }
}
