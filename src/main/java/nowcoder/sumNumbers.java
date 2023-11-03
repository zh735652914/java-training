package nowcoder;
/*
 牛客题霸-名企高频面试题
二叉树根节点到叶子节点的所有路径和 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：32875
本题知识点： 树 dfs
 算法知识视频讲解
题目描述
给定一个仅包含数字\ 0-9 0−9 的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
例如根节点到叶子节点的一条路径是1\to 2\to 31→2→3,那么这条路径就用\ 123 123 来代替。
找出根节点到叶子节点的所有路径表示的数字之和
例如：

这颗二叉树一共有两条路径，
根节点到叶子节点的路径 1\to 21→2 用数字\ 12 12 代替
根节点到叶子节点的路径 1\to 31→3 用数字\ 13 13 代替
所以答案为\ 12+13=25 12+13=25
示例1
输入
复制
{1,0}
输出
复制
10
示例2
输入
复制
{1,#,9}
输出
复制
19
 */

import java.util.LinkedList;
import java.util.Queue;

public class sumNumbers {
    static public class Solution {
        /**
         * @param root TreeNode类
         * @return int整型
         */
        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return getSum(root, 0);
        }

        private int getSum(TreeNode root, int num) {
            if (root == null) {
                return num;
            }
            num *= 10;
            num += root.val;
            if (root.left == null && root.right == null) {
                return num;
            }
            if (root.right == null) {
                return getSum(root.left, num);
            }
            if (root.left == null) {
                return getSum(root.right, num);
            }
            return getSum(root.left, num) + getSum(root.right, num);
        }
    }

    static class buildTree {
        public TreeNode built_Tree(String s) {
            String[] nodes = s.substring(1, s.length() - 1).split(",");
            TreeNode root = mkNode(nodes, 0);
            int index = 1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
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
            if (index < 0 || index >= nodes.length || nodes[index].equals("#")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(nodes[index]));
        }
    }

    public static void main(String[] args) {
        String nodes = "{1,2,3}";
        TreeNode root = new buildTree().built_Tree(nodes);
        System.out.println(new Solution().sumNumbers(root));
    }
}
