package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：442814
本题知识点： 树
 算法知识视频讲解
题目描述
给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */

import java.util.LinkedList;
import java.util.Queue;

public class KthNode {
    static public class Solution {
        private int count;

        TreeNode KthNode(TreeNode pRoot, int k) {
            count = 0;
            return find(pRoot, k);
        }

        private TreeNode find(TreeNode root, int k) {
            if (root == null) {
                return null;
            }
            TreeNode left = find(root.left, k);
            if (++count == k) {
                return root;
            }
            TreeNode right = find(root.right, k);
            if (left != null) {
                return left;
            } else {
                return right;
            }
        }
    }

    static class buildTree {
        public TreeNode buildTreeNode(String s) {
            s = s.substring(1, s.length() - 1);
            String[] nodes = s.split(",");
            TreeNode root = mkNode(nodes, 0);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                cur.left = mkNode(nodes, index++);
                cur.right = mkNode(nodes, index++);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            return root;
        }

        private TreeNode mkNode(String[] nodes, int index) {
            if (index >= nodes.length || index < 0) {
                return null;
            }
            return new TreeNode(Integer.parseInt(nodes[index]));
        }
    }

    public static void main(String[] args) {
        String nodes = "(5,3,7,2,4,6,8)";
        TreeNode root = new buildTree().buildTreeNode(nodes);
        int k = 3;
        System.out.println(new Solution().KthNode(root, k).val);
    }

}
