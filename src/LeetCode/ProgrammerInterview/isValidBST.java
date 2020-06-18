package LeetCode.ProgrammerInterview;
/*
v面试题 04.05. 合法二叉搜索树
实现一个函数，检查一棵二叉树是否为二叉搜索树。

示例 1:
输入:
    2
   / \
  1   3
输出: true
示例 2:
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
通过次数4,231提交次数12,417
 */

import java.util.Stack;

//感觉自己很智障，都不会写了。。。
public class isValidBST {
    static class Solution {
        Stack<Integer> stack;

        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            stack = new Stack<>();
            inorder_visit(root);
            int last = stack.pop();
            while (!stack.isEmpty()) {
                if (last <= stack.peek()) {
                    return false;
                }
                last = stack.pop();
            }
            return true;
        }

        private void inorder_visit(TreeNode root) {
            if (root == null) return;
            inorder_visit(root.left);
            stack.push(root.val);
            inorder_visit(root.right);
        }
    }

    public static void main(String[] args) {
//        String[] nodes = {"5", "1", "4", "null", "null", "3", "6"};
        String[] nodes = {"-2147483648", "null", "2147483647", "-2147483647"};
//        String[] nodes = {"2147483647"};
        TreeNode root = new BuildTree().level_build_tree(nodes);
        System.out.println(new Solution().isValidBST(root));
    }
}
