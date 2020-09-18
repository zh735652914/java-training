package nowcoder;
/*
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：3207
本题知识点： 树
 算法知识视频讲解
题目描述
给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
示例1
输入
复制
[3,5,1,6,2,0,8,#,#,7,4],5,1
输出
复制
3
 */

import java.util.LinkedList;
import java.util.Queue;

public class lowestCommonAncestor {
    static public class Solution {
        /**
         * @param root TreeNode类
         * @param o1   int整型
         * @param o2   int整型
         * @return int整型
         */
        public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
            return findAncestor(root, o1, o2).val;
        }

        private TreeNode findAncestor(TreeNode root, int o1, int o2) {
            if (root == null || root.val == o1 || root.val == o2) {
                return root;
            }
            TreeNode left = findAncestor(root.left, o1, o2);
            TreeNode right = findAncestor(root.right, o1, o2);
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return root;
        }
    }

    static class buildTree {
        public TreeNode built_tree(String s) {
            s = s.substring(1, s.length() - 1);
            String[] nodes = s.split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            if (nodes.length == 0 || nodes[0].equals("#")) {
                return null;
            }
            TreeNode root = mkNode(nodes, 0);
            queue.offer(root);
            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode tmp = queue.poll();
                tmp.left = mkNode(nodes, index++);
                tmp.right = mkNode(nodes, index++);
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            return root;
        }

        private TreeNode mkNode(String[] nodes, int index) {
            if (index >= nodes.length) {
                return null;
            }
            String node = nodes[index];
            if (node.equals("#")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(node));
        }
    }

    public static void main(String[] args) {
        String nodes = "[3,5,1,6,2,0,8,#,#,7,4]";
        TreeNode root = new buildTree().built_tree(nodes);
        int o1 = 5;
        int o2 = 1;
        System.out.println(new Solution().lowestCommonAncestor(root, o1, o2));
    }
}
