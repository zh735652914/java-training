package Beijing.hot100;
/*
https://leetcode.cn/problems/merge-two-binary-trees/
 */

import Beijing.BuildTree;
import Beijing.PrintTree;
import Beijing.TreeNode;

// 第二次写居然有点坎坷
public class mergeTwoBinaryTrees_617 {
    static class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return null;
            } else if (root2 == null) {
                return root1;
            } else if (root1 == null) {
                return root2;
            }
            root1.val += root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }

    public static void main(String[] args) {
        String[] nodes1 = {"1", "3", "2", "5"};
        String[] nodes2 = {"2", "1", "3", "null", "4", "null", "7"};
        TreeNode root1 = new BuildTree().LevelBuildTree(nodes1);
        TreeNode root2 = new BuildTree().LevelBuildTree(nodes2);
        TreeNode root = new Solution().mergeTrees(root1, root2);
        new PrintTree().LevelPrintTree(root);
    }
}
