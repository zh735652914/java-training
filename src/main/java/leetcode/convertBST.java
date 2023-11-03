package leetcode;
/*538. 把二叉搜索树转换为累加树
给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。



例如：

输入: 原始二叉搜索树:
              5
            /   \
           2     13

输出: 转换为累加树:
             18
            /   \
          20     13


注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同

通过次数38,142提交次数60,233

 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class convertBST {
    static class Solution {
        public TreeNode convertBST(TreeNode root) {
            visit(root, 0);
            return root;
        }

        private int visit(TreeNode root, int last) {
            if (root == null) {
                return last;
            }
            last = visit(root.right, last);
            root.val += last;
            last = root.val;
            last = visit(root.left, last);
            return last;
        }
    }


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
        String nodes = "[5,2,13]";
        convertBST convertBST = new convertBST();
        TreeNode root = convertBST.deserialize(nodes);
        TreeNode after = new Solution().convertBST(root);
        new travelTree().levelTree(after);
    }
}
