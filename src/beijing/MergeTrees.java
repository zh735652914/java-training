package beijing;
/*
https://leetcode.cn/problems/merge-two-binary-trees/
 */

/**
 * @author zhouhao
 * @date 2023/8/14 14:06
 */
public class MergeTrees {
    static class Solution {
        // 很简单的题目
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            TreeNode root = null;
            if (root1 != null && root2 != null) {
                root = new TreeNode(root1.val + root2.val);
                root.left = mergeTrees(root1.left, root2.left);
                root.right = mergeTrees(root1.right, root2.right);
            } else if (root1 != null) {
                root = root1;
            } else if (root2 != null) {
                root = root2;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        String nodes1 = "[1,3,2,5]";
        String nodes2 = "[2,1,3,null,4,null,7]";
        TreeNode root1 = new BuildTree().LevelBuildTree(nodes1);
        TreeNode root2 = new BuildTree().LevelBuildTree(nodes2);
        new PrintTree().LevelPrintTree(new Solution().mergeTrees(root1, root2));
    }
}
