package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：31124
本题知识点： 树 dfs
 算法知识视频讲解
题目描述
求给定二叉树的最大深度，
最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。

示例1
输入
复制
{1,2}
输出
复制
2
示例2
输入
复制
{1,2,3,4,#,#,5}
输出
复制
3
 */

import java.util.LinkedList;
import java.util.Queue;

public class maxDepth {
    static public class Solution {
        /**
         * @param root TreeNode类
         * @return int整型
         */
        public int maxDepth(TreeNode root) {
            return findDeep(root, 0);
        }

        private int findDeep(TreeNode root, int deep) {
            if (root == null) {
                return deep;
            }
            deep++;
            return Math.max(findDeep(root.left, deep), findDeep(root.right, deep));
        }
    }

    static class buildTree {
        public TreeNode build_Tree(String s) {
            s = s.substring(1, s.length() - 1);
            String[] nodes = s.split(",");
            if (nodes[0].equals("#")) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = mkTreeNode(nodes, 0);
            queue.offer(root);
            int index = 1;
            TreeNode pos = null;
            while (!queue.isEmpty()) {
                pos = queue.poll();
                pos.left = mkTreeNode(nodes, index++);
                pos.right = mkTreeNode(nodes, index++);
                if (pos.left != null) {
                    queue.offer(pos.left);
                }
                if (pos.right != null) {
                    queue.offer(pos.right);
                }
            }
            return root;
        }

        private TreeNode mkTreeNode(String[] nodes, int index) {
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
        String nodes = "{1,2,3,4,#,#,5}";
        TreeNode root = new buildTree().build_Tree(nodes);
        System.out.println(new Solution().maxDepth(root));
    }
}
