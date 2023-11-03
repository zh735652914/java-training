package beijing;
/*
https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

import java.util.HashMap;
import java.util.Map;

public class buildTree_105 {
    // 自己居然又不会写了
    static class Solution {
        private Map<Integer, Integer> map;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return backtrack(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode backtrack(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            int leftCount = map.get(root.val) - inStart;
            root.left = backtrack(preorder, preStart + 1, preStart + leftCount, inorder, inStart, inStart + leftCount - 1);
            root.right = backtrack(preorder, preStart + leftCount + 1, preEnd, inorder, inStart + leftCount + 1, inEnd);
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
