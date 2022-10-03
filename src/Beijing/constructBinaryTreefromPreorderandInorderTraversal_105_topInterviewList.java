package Beijing;
/*
https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

import java.util.HashMap;
import java.util.Map;

public class constructBinaryTreefromPreorderandInorderTraversal_105_topInterviewList {
    // 还是要多写写
    static class Solution {
        private Map<Integer, Integer> map;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return constructTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode constructTree(int[] preorder, int[] inorder, int startPre, int endPre, int startIn, int endIn) {
            if (startPre > endPre) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[startPre]);
            int leftCount = map.get(root.val) - startIn;
            root.left = constructTree(preorder, inorder, startPre + 1, startPre + leftCount, startIn, startIn + leftCount - 1);
            root.right = constructTree(preorder, inorder, startPre + leftCount + 1, endPre, startIn + leftCount + 1, endIn);
            return root;
        }
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        TreeNode root = new Solution().buildTree(preorder, inorder);
        new PrintTree().LevelPrintTree(root);
    }
}
