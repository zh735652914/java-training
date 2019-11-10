package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */

class PathSumIISolution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> aAns = new ArrayList<>();
        aAns.add(root.val);
        backtrack(root, sum, root.val, ans, aAns);
        return ans;
    }

    private void backtrack(TreeNode root, int target, int sum, List<List<Integer>> ans, List<Integer> aAns) {
        if (root.left == null && root.right == null) {
            if (sum == target) {
                ans.add(aAns);
//                System.out.println("tmp= " + ans);
            } else {
                return;
            }
        }
        if (root.left != null) {
            aAns.add(root.left.val);
            backtrack(root.left, target, sum + root.left.val, ans, new ArrayList<>(aAns));
            aAns.remove(aAns.size() - 1);
        }
        if (root.right != null) {
            aAns.add(root.right.val);
            backtrack(root.right, target, sum + root.right.val, ans, new ArrayList<>(aAns));
            aAns.remove(aAns.size() - 1);
        }
    }
}

public class PathSumII {
    public static void main(String[] args) {
        int[] preorder = {5, 4, 11, 7, 2, 8, 13, 4, 5, 1};
        int[] inorder = {7, 11, 2, 4, 5, 13, 8, 5, 4, 1};
        BuildTree buildTree = new BuildTree();
        TreeNode root = buildTree.BuildTree(preorder, inorder);
        int sum = 22;
        PathSumIISolution pathSumIISolution = new PathSumIISolution();
        System.out.println(pathSumIISolution.pathSum(root, sum));
    }
}
