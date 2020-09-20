package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：22935
本题知识点： 栈 树 bfs
 算法知识视频讲解
题目描述
给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
例如：
给定的二叉树是{3,9,20,#,#,15,7},

该二叉树之字形层序遍历的结果是
[
[3],
[20,9],
[15,7]
]
示例1
输入
复制
{1,#,2}
输出
复制
[[1],[2]]
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class zigzagLevelOrder {
    static public class Solution {
        /**
         * @param root TreeNode类
         * @return int整型ArrayList<ArrayList <>>
         */
        public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean flag = true;
            TreeNode cur = null;
            while (!queue.isEmpty()) {
                int count = queue.size();
                ArrayList<Integer> level = new ArrayList<>();
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i < count; i++) {
                    cur = queue.poll();
                    if (!flag) {
                        stack.push(cur.val);
                    } else {
                        level.add(cur.val);
                    }
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                while (!flag && !stack.isEmpty()) {
                    level.add(stack.pop());
                }
                ans.add(level);
                flag = !flag;
            }
            return ans;
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
        String nodes = "[3,9,20,#,#,15,7]";
        TreeNode root = new buildTree().build_Tree(nodes);
        System.out.println(new Solution().zigzagLevelOrder(root));
    }
}
