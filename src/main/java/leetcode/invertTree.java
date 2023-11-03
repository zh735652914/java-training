package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class invertTree {
    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
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
        String nodes = "[4,2,7,1,3,6,9]";
        TreeNode root = new buildTree().deserialize(nodes);
        TreeNode after = new Solution().invertTree(root);
        System.out.println(new outputTree().serialize(after));
    }
}
