package LeetCode;

/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
class ConstructBinaryTreefromInorderandPostorderTraversalSolution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return backtrack(inorder, postorder, postorder.length - 1, 0, inorder.length - 1, 0);
    }

    private TreeNode backtrack(int[] inorder, int[] postorder, int index, int start, int end, int poststart) {
        if (index < 0 || index < poststart) return null;
        TreeNode root = new TreeNode(postorder[index]);
        int pos = -1;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == postorder[index]) {
                pos = i;
                break;
            }
        }
        root.left = backtrack(inorder, postorder, index - (end - pos) - 1, start, pos - 1, poststart);
        root.right = backtrack(inorder, postorder, index - 1, pos + 1, end, poststart + (pos - start));
        return root;
    }

}

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public static void main(String[] args) {
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        ConstructBinaryTreefromInorderandPostorderTraversalSolution SO = new ConstructBinaryTreefromInorderandPostorderTraversalSolution();
        BinaryTreeLevelOrderTraversalSolution BTO = new BinaryTreeLevelOrderTraversalSolution();
        System.out.println(BTO.levelOrder(SO.buildTree(inorder, postorder)));
    }
}
