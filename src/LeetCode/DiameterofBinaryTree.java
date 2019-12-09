package LeetCode;

/*
Given a binary tree, you need to compute the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 */
//不是自己写的。。。
class DiameterofBinaryTreeSolution {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        backtrack(root);
        return ans;
    }

    private int backtrack(TreeNode root) {
        if (root == null) return 0;
        int L = backtrack(root.left);
        int R = backtrack(root.right);
        ans = Math.max(L + R, ans);
        return 1 + Math.max(L, R);
    }
}

public class DiameterofBinaryTree {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        TreeNode root = new BuildTree().LevelBuildInteger(nums);
        DiameterofBinaryTreeSolution diameterofBinaryTreeSolution = new DiameterofBinaryTreeSolution();
        System.out.println(diameterofBinaryTreeSolution.diameterOfBinaryTree(root));
    }
}
