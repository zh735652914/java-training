package nowcoder;
/*
 牛客题霸-名企高频面试题
判断t1树中是否有与t2树拓扑结构完全相同的子树
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：1824
本题知识点： 树
 算法知识视频讲解
题目描述
给定彼此独立的两棵二叉树，判断 t1 树是否有与 t2 树拓扑结构完全相同的子树。
设 t1 树的边集为 E1，t2 树的边集为 E2，若 E2 等于 E1 ，则表示 t1 树和t2 树的拓扑结构完全相同。
示例1
输入
复制
{1,2,3,4,5,6,7,#,8,9},{2,4,5,#,8,9}
输出
复制
true
备注:
1 \leq n \leq 5000001≤n≤500000
说明：本题目包含复杂数据结构TreeNode，点此查看相关信息
 */

import java.util.LinkedList;
import java.util.Queue;

public class isContains {
    static class TreeNode {
        TreeNode left = null;
        TreeNode right = null;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class buildTree {
        public TreeNode mkTree(String s) {
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
            if (index < 0 || index >= nodes.length - 1 || nodes[index].equals("#")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(nodes[index]));
        }
    }

    static public class Solution {
        /**
         * @param root1 TreeNode类
         * @param root2 TreeNode类
         * @return bool布尔型
         */
        public boolean isContains(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return root2 == null;
            }
            if (root2 == null) {
                return true;
            }
            boolean flag = false;
            if (root1.val == root2.val) {
                flag = isContains(root1.left, root2.left) && isContains(root1.right, root2.right);
            }
            if (flag) {
                return true;
            }
            return isContains(root1.left, root2) || isContains(root1.right, root2);
        }
    }

    public static void main(String[] args) {
        String E1 = "{1,2,3,4,5,6,7,#,8,9}";
        String E2 = "{2,4,5,#,8,9}";
        TreeNode t1 = new buildTree().mkTree(E1);
        TreeNode t2 = new buildTree().mkTree(E2);
        System.out.println(new Solution().isContains(t1, t2));
    }
}
