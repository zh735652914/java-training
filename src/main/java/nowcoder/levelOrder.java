package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：25444
本题知识点： 树 bfs
 算法知识视频讲解
题目描述
给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
例如：
给定的二叉树是{3,9,20,#,#,15,7},

该二叉树层序遍历的结果是
[
[3],
[9,20],
[15,7]
]

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree{3,9,20,#,#,15,7},

return its level order traversal as:
[
[3],
[9,20],
[15,7]
]

示例1
输入
复制
{1,2}
输出
复制
[[1],[2]]
示例2
输入
复制
{1,2,3,4,#,#,5}
输出
复制
[[1],[2,3],[4,5]]
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class levelOrder {
    static public class Solution {
        /**
         * @param root TreeNode类
         * @return int整型ArrayList<ArrayList <>>
         */
        public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    TreeNode cur = queue.poll();
                    list.add(cur.val);
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                ans.add(list);
            }
            return ans;
        }
    }

    static class buildTree {
        public TreeNode buildtree(String s) {
            s = s.substring(1, s.length() - 1);
            String[] nodes = s.split(",");
            if (nodes.length == 0) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = mkNode(nodes[0]);
            queue.offer(root);
            TreeNode p;
            int index = 1;
            while (!queue.isEmpty()) {
                p = queue.poll();
                if (index < nodes.length) {
                    p.left = mkNode(nodes[index++]);
                }
                if (index < nodes.length) {
                    p.right = mkNode(nodes[index++]);
                }
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            return root;
        }

        private TreeNode mkNode(String x) {
            if (x.equals("#")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(x));
        }
    }

    public static void main(String[] args) {
        String nodes = "[1,2,3,4,#,#,5]";
        TreeNode root = new buildTree().buildtree(nodes);
        System.out.println(new Solution().levelOrder(root));
    }
}
