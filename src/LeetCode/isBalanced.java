package LeetCode;
/*
110. 平衡二叉树
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。



通过次数132,785提交次数243,089
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class isBalanced {
    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (Math.abs(findDeep(root.left, 1) - findDeep(root.right, 1)) > 1) {
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);
        }

        private int findDeep(TreeNode root, int deep) {
            if (root == null) {
                return deep;
            }
            return Math.max(findDeep(root.left, deep + 1), findDeep(root.right, deep + 1));
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

    static class travelTree {

        public void levelTree(TreeNode root) {
            List<List<Integer>> levelList = new ArrayList<>();
            System.out.println(levelVisit(root, 0, levelList));
        }

        private List<List<Integer>> levelVisit(TreeNode node, int deep, List<List<Integer>> levelList) {
            if (node == null) return levelList;
            if (levelList.size() <= deep) {
                List<Integer> alevel = new ArrayList<>();
                alevel.add(node.val);
                levelList.add(alevel);
            } else {
                levelList.get(deep).add(node.val);
            }
            levelVisit(node.left, deep + 1, levelList);
            levelVisit(node.right, deep + 1, levelList);
            return levelList;
        }
    }

    public static void main(String[] args) {
        String nodes = "[1,2,2,3,3,null,null,4,4]";
        TreeNode root = new buildTree().deserialize(nodes);
        System.out.println(new Solution().isBalanced(root));
    }
}
