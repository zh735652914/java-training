package Beijing;
/*
https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    // 这个最基本的建树，我居然不会了
    static class Solution {
        private Map<Integer, Integer> map;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            map = new HashMap<>(inorder.length);
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return backtrack(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
        }

        private TreeNode backtrack(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
            if (preStart > preEnd) {
                return null;
            }
            int preRoot = preorder[preStart];
            TreeNode root = new TreeNode(preRoot);
            int leftCount = map.get(preRoot) - inStart;
            root.left = backtrack(preorder, inorder, preStart + 1, preStart + leftCount, inStart, inStart + leftCount - 1);
            root.right = backtrack(preorder, inorder, preStart + 1 + leftCount, preEnd, inStart + leftCount + 1, inEnd);
            return root;
        }
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = new Solution().buildTree(preorder, inorder);
        new PrintTree().LevelPrintTree(root);
    }
}
