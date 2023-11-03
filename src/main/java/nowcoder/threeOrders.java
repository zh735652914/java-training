package nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class threeOrders {
    public static class Solution {
        /**
         * @param root TreeNode类 the root of binary tree
         * @return int整型二维数组
         */
        List<Integer> list;

        public int[][] threeOrders(TreeNode root) {
            list = new ArrayList<>();
            perOrder(root);
            int[][] ans = new int[3][list.size()];
            toAns(ans, list, 0);
            list.clear();
            inOrder(root);
            toAns(ans, list, 1);
            list.clear();
            postOrder(root);
            toAns(ans, list, 2);
            return ans;
        }

        private void toAns(int[][] ans, List<Integer> list, int index) {
            for (int i = 0; i < list.size(); i++) {
                ans[index][i] = list.get(i);
            }
        }

        private void perOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            perOrder(root.left);
            perOrder(root.right);
        }

        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }

        private void postOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            list.add(root.val);
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
        String nodes = "[1,2,3]";
        TreeNode root = new buildTree().deserialize(nodes);
        int[][] ans = new Solution().threeOrders(root);
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
