package Beijing;
/*
https://leetcode.cn/problems/binary-tree-pruning/
 */

// 两年前会写的，现在反而不会写了
public class pruneTree {
    static class Solution {
        public TreeNode pruneTree(TreeNode root) {
            if (noOne(root)) {
                return null;
            }
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            return root;
        }

        private boolean noOne(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.val == 1) {
                return false;
            }
            return noOne(root.left) && noOne(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new BuildTree().LevelBuildTree("[1,null,0,0,1]");
        TreeNode ans = new Solution().pruneTree(root);
        new PrintTree().LevelPrintTree(ans);
    }
}
