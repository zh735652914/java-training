package leetcode.programmerInterview;
/*
面试题 17.12. BiNode
二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。

返回转换后的单向链表的头节点。

注意：本题相对原题稍作改动



示例：

输入： [4,2,5,1,3,null,6,0]
输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
提示：

节点数量不会超过 100000。
通过次数7,200提交次数11,802
 */

//这题之前写过，但是也有点小坑
public class convertBiNode {
    static class Solution {
        TreeNode p;

        public TreeNode convertBiNode(TreeNode root) {
            TreeNode head = new TreeNode(-1);
            this.p = head;
            inOrder(root);
            return head.right;
        }

        private void inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.left);
            this.p.right = root;
            this.p = p.right;
            root.left = null;
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        String[] nums = {"4", "2", "5", "1", "3", "null", "6", "0"};
        TreeNode root = new BuildTree().level_build_tree(nums);
        TreeNode ans = new Solution().convertBiNode(root);
        TreeNode p = ans;
        while (p != null) {
            System.out.print(p.val + ",");
            p = p.right;
        }
        System.out.println();
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */