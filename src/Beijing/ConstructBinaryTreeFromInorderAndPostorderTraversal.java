package Beijing;
/*
https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */

import java.util.HashMap;
import java.util.Map;

// 太久没写这个了
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    static class Solution {
        private Map<Integer, Integer> map;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return backtrack(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode backtrack(int[] inorder, int[] postorder, int index, int start, int end) {
            if (start > end) {
                return null;
            }
            int val = postorder[index];
            TreeNode root = new TreeNode(val);
            int pos = map.get(val);
            int rightCount = end - pos;
            root.left = backtrack(inorder, postorder, index - rightCount - 1, start, pos - 1);
            root.right = backtrack(inorder, postorder, index - 1, pos + 1, end);
            return root;
        }
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = new Solution().buildTree(inorder, postorder);
        new PrintTree().LevelPrintTree(root);
    }
}
