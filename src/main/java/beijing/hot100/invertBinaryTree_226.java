package beijing.hot100;
/*
https://leetcode.cn/problems/invert-binary-tree/
 */

import beijing.BuildTree;
import beijing.PrintTree;
import beijing.TreeNode;

public class invertBinaryTree_226 {
    // 很经典的简单题
    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return root;
            }
            TreeNode L = invertTree(root.left);
            TreeNode R = invertTree(root.right);
            root.left = R;
            root.right = L;
            return root;
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"4", "2", "7", "1", "3", "6", "9"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        TreeNode ans = new Solution().invertTree(root);
        new PrintTree().LevelPrintTree(ans);
    }
}
