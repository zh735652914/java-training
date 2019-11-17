package LeetCode;

/*
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew),
but you can’t invert a binary tree on a whiteboard so f*** off.
 */
class InvertBinaryTreeSolution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}

public class InvertBinaryTree {
    public static void main(String[] args) {
        int[] nums = {4, 2, 7, 1, 3, 6};
        BuildTree buildTree = new BuildTree();
        TreeNode root = buildTree.LevelBuildInteger(nums);
        InvertBinaryTreeSolution invertBinaryTreeSolution = new InvertBinaryTreeSolution();
        BinaryTreeLevelOrderTraversalSolution binaryTreeLevelOrderTraversalSolution = new BinaryTreeLevelOrderTraversalSolution();
        System.out.println(binaryTreeLevelOrderTraversalSolution.levelOrder(invertBinaryTreeSolution.invertTree(root)));
    }
}
