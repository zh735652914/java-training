package LeetCode;
/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeInorderTraversalSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> S = new Stack<>();
        while (root != null || !S.empty()) {
            while (root != null) {
                S.push(root);
                root = root.left;
            }
            root = S.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 3, 2};
        BuildTree BT = new BuildTree();
        TreeNode root = BT.Build(preorder, inorder);
        BinaryTreeInorderTraversalSolution BTIT = new BinaryTreeInorderTraversalSolution();
        System.out.println(BTIT.inorderTraversal(root));
    }
}
