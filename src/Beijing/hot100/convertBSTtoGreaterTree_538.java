package Beijing.hot100;
/*
https://leetcode.cn/problems/convert-bst-to-greater-tree/
 */

import Beijing.BuildTree;
import Beijing.PrintTree;
import Beijing.TreeNode;

public class convertBSTtoGreaterTree_538 {
    // 很重要！自己不会写了
    static class Solution {
        public int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
            return root;
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"4", "1", "6", "0", "2", "5", "7", "null", "null", "null", "3", "null", "null", "null", "8"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        new PrintTree().LevelPrintTree(new Solution().convertBST(root));
    }
}
