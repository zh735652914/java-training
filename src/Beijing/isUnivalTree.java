package Beijing;
/*
https://leetcode.cn/problems/univalued-binary-tree/
 */

public class isUnivalTree {
    static class Solution {
        private int value;

        public boolean isUnivalTree(TreeNode root) {
            if (root == null) {
                return true;
            }
            value = root.val;
            return dfs(root.left) && dfs(root.right);
        }

        private boolean dfs(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.val != value) {
                return false;
            }
            return dfs(root.left) && dfs(root.right);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "1", "1", "1", "1", "null", "1"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().isUnivalTree(root));
    }
}