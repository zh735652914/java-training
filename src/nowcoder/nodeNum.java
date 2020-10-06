package nowcoder;
/*
 牛客题霸-名企高频面试题
完全二叉树结点数
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：1510
本题知识点： 树 二分
 算法知识视频讲解
题目描述
给定一棵完全二叉树的头节点head，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
说明：本题目包含复杂数据结构TreeNode，点此查看相关信息
题解 讨论 通过的代码笔记 纠错 收藏
 */

import java.util.LinkedList;
import java.util.Queue;

//力扣第222题 https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/wan-quan-er-cha-shu-de-jie-dian-ge-shu-by-leetcode/
public class nodeNum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class buildTree {
        public TreeNode mkTree(String s) {
            s = s.substring(1, s.length() - 1);
            String[] nodes = s.split(",");
            TreeNode root = mkNode(nodes, 0);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
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
            if (index < 0 || index >= nodes.length || nodes[index].equals("#")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(nodes[index]));
        }
    }

    static public class Solution {
        public int nodeNum(TreeNode head) {
            if (head == null) {
                return 0;
            }
            int deep = findDeep(head) - 1;
            //这里的left和right要注意一下，最后得到的left是最后一个不存在节点的编号
            int left = 1, right = (int) Math.pow(2, deep) - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (isExists(mid, deep, head)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return (int) Math.pow(2, deep) - 1 + left;
        }

        private boolean isExists(int index, int deep, TreeNode root) {
            int left = 0, right = (int) Math.pow(2, deep) - 1;
            for (int i = 0; i < deep; i++) {
                int mid = (left + right) / 2;
                if (index <= mid) {
                    right = mid;
                    root = root.left;
                } else {
                    left = mid + 1;
                    root = root.right;
                }
            }
            return root != null;
        }

        private int findDeep(TreeNode root) {
            int count = 0;
            while (root != null) {
                count++;
                root = root.left;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        String s = "{1,2,3,4,5}";
        TreeNode root = new buildTree().mkTree(s);
        System.out.println(new Solution().nodeNum(root));
    }
}
