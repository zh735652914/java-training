package beijing;
/*
https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */

public class minDepth {
    static class Solution {

        private int minDeep = Integer.MAX_VALUE;

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            down(root, 1);
            return minDeep;
        }

        private void down(TreeNode root, int level) {
            if (root.left == null && root.right == null) {
                minDeep = Math.min(minDeep, level);
                return;
            }
            level++;
            if (root.left != null) {
                down(root.left, level);
            }
            if (root.right != null) {
                down(root.right, level);
            }
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"2", "null", "3", "null", "4", "null", "5", "null", "6"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().minDepth(root));
    }
}
