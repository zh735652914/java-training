package beijing;
/*
https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */

import java.util.HashMap;
import java.util.Map;

public class buildTree_106 {
    // 自己没写出来，顺序很重要！！！！！
    static class Solution {
        private Map<Integer, Integer> map;
        private int index;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            index = postorder.length - 1;
            return backtrack(0, inorder.length - 1, postorder);
        }

        private TreeNode backtrack(int start, int end, int[] postorder) {
            if (start > end || index < 0) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[index--]);
            int leftCount = map.get(root.val) - start;
            // 下面的顺序不能变！！！！
            root.right = backtrack(start + leftCount + 1, end, postorder);
            root.left = backtrack(start, start + leftCount - 1, postorder);
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
