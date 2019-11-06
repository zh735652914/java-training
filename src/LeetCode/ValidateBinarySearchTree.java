package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */
//中序遍历排序二叉树！！！！！！！结果一定是有序的
class ValidateBinarySearchTreeSolution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> Val = new ArrayList<>();
        backtrack(root, Val);
        int last = Val.get(0);
        for (int i = 1; i < Val.size(); i++) {
            if (last >= Val.get(i)) return false;
            last = Val.get(i);
        }
        return true;
    }

    private void backtrack(TreeNode root, List<Integer> Val) {
        if (root == null) return;
        backtrack(root.left, Val);
        Val.add(root.val);
        backtrack(root.right, Val);
    }
}

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
//        String[] s = {"5", "1", "4", "null", "null", "3", "6"};
        String[] s = {"2", "1", "3"};
//        String[] s = {"10", "5", "15", "null", "null", "6", "20"};
        BuildTree BT = new BuildTree();
        TreeNode root = BT.LevelBuild(s);
        ValidateBinarySearchTreeSolution VBS = new ValidateBinarySearchTreeSolution();
        System.out.println(VBS.isValidBST(root));
    }
}
