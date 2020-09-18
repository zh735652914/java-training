package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：354126
本题知识点： 树 dfs
 算法知识视频讲解
题目描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。

在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 */

import java.util.LinkedList;
import java.util.Queue;

public class IsBalanced_Solution {
    static public class Solution {
        public boolean IsBalanced_Solution(TreeNode root) {
            if (root == null) {
                return true;
            }
            int left = isBalance(root.left, 0);
            int right = isBalance(root.right, 0);
            if (Math.abs(left - right) > 1) {
                return false;
            }
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }

        private int isBalance(TreeNode root, int deep) {
            if (root == null) {
                return deep;
            }
            return Math.max(isBalance(root.left, deep + 1), isBalance(root.right, deep + 1));
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

    public static void main(String[] args) {
        String nodes = "[1,2,3,4,5,null,null,7]";
        TreeNode root = new buildTree().deserialize(nodes);
        System.out.println(new Solution().IsBalanced_Solution(root));
    }
}
