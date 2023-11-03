package beijing;
/*
https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */

public class maxDepth {
    static class Solution {

        private int deep = 0;

        public int maxDepth(TreeNode root) {
            down(root, 0);
            return deep;
        }

        private void down(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            level++;
            deep = Math.max(deep, level);
            down(root.left, level);
            down(root.right, level);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"3", "9", "20", "null", "null", "15", "7"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().maxDepth(root));
    }
}
