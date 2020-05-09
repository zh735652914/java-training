package LeetCode.ProgrammerInterview;
/*
面试题 04.04. 检查平衡性
实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。


示例 1:
给定二叉树 [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
返回 true 。
示例 2:
给定二叉树 [1,2,2,3,3,null,null,4,4]
      1
     / \
    2   2
   / \
  3   3
 / \
4   4
返回 false 。
通过次数4,731提交次数8,241
 */

public class isBalanced {
    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            if (Math.abs(Max_deep(root.left) - Max_deep(root.right)) > 1) return false;
            return isBalanced(root.left) && isBalanced(root.right);
        }

        private int Max_deep(TreeNode root) {
            if (root == null) return 0;
            return Math.max(Max_deep(root.left), Max_deep(root.right)) + 1;
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"3", "9", "20", "null", "null", "15", "7"};
        TreeNode root = new BuildTree().level_build_tree(nodes);
        System.out.println(new Solution().isBalanced(root));
    }
}
