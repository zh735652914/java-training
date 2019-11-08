package LeetCode;

import sun.reflect.generics.tree.Tree;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
class ConstructBinaryTreefromPreorderandInorderTraversalSolution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return backtrack(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode backtrack(int[] preorder, int[] inorder, int index, int start, int end) {
        if (index >= preorder.length || start > end) return null;
        TreeNode root = new TreeNode(preorder[index]);
        int pos = -1;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == preorder[index]) {
                pos = i;
                break;
            }
        }
        index++;
        root.left = backtrack(preorder, inorder, index, start, pos - 1);
        if (root.left != null) {
            index += (pos - start);
        }
        root.right = backtrack(preorder, inorder, index, pos + 1, end);
        return root;
    }
}

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
//        int[] preorder = {3, 1, 2, 4};
//        int[] inorder = {1, 2, 3, 4};
        ConstructBinaryTreefromPreorderandInorderTraversalSolution CBTP = new ConstructBinaryTreefromPreorderandInorderTraversalSolution();
        BinaryTreeLevelOrderTraversalSolution BTO = new BinaryTreeLevelOrderTraversalSolution();
        System.out.println(BTO.levelOrder(CBTP.buildTree(preorder, inorder)));
    }
}
