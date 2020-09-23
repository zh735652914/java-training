package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：295448
本题知识点： 树 bfs
 算法知识视频讲解
题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
说明：本题目包含复杂数据结构TreeNode，点此查看相关信息
题解 讨论 通过的代码笔记 纠错 收藏
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Print {
    static public class Solution {
        ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            Queue<TreeNode> queue = new LinkedList<>();
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            if (pRoot == null) {
                return ans;
            }
            queue.offer(pRoot);
            while (!queue.isEmpty()) {
                int len = queue.size();
                ArrayList<Integer> list = new ArrayList<>();
                TreeNode cur = null;
                for (int i = 0; i < len; i++) {
                    cur = queue.poll();
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
        public TreeNode build_tree(String s) {
            s = s.substring(1, s.length() - 1);
            String[] nodes = s.split(",");
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
        String nodes = "[1,2,3,4,5]";
        TreeNode root = new buildTree().build_tree(nodes);
        System.out.println(new Solution().Print(root));
    }
}
