package leetcode;
/*
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */

class FlattenBinaryTreetoLinkedListSolution {
    public void flatten(TreeNode root) {
        backtrack(root);
    }

    private TreeNode backtrack(TreeNode root) {
        if (root == null || isLeaf(root)) return root;
        if (root.left != null && root.right != null) {
            if (isLeaf(root.left) && isLeaf(root.right)) {
                root.left.right = root.right;
                root.right = root.left;
                root.left = null;
                return root;
            }
            root.left = backtrack(root.left);
            TreeNode LeftTail = root.left;
            while (LeftTail.right != null) {
                LeftTail = LeftTail.right;
            }
            LeftTail.right = backtrack(root.right);
            root.right = root.left;
            root.left = null;
            return root;
        } else if (root.left == null) {
            root.right = backtrack(root.right);
        } else {
            root.left = backtrack(root.left);
            root.right = root.left;
            root.left = null;
        }
        return root;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}

public class FlattenBinaryTreetoLinkedList {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 3, 4, 5, 6};
        int[] inorder = {3, 2, 4, 1, 5, 6};
        BuildTree buildTree = new BuildTree();
        TreeNode root = buildTree.BuildTree(preorder, inorder);
        FlattenBinaryTreetoLinkedListSolution flattenBinaryTreetoLinkedListSolution = new FlattenBinaryTreetoLinkedListSolution();
        flattenBinaryTreetoLinkedListSolution.flatten(root);
        TreeNode p = root;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.right;
        }
    }
}
