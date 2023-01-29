package beijing;
/*
https://leetcode-cn.com/problems/path-sum/
 */

public class hasPathSum {
    static class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null || (root.val != targetSum && isLeaf(root))) {
                return false;
            }
            if (root.val == targetSum && isLeaf(root)) {
                return true;
            }
            targetSum -= root.val;
            return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
        }

        private boolean isLeaf(TreeNode root) {
            if (root == null) {
                return false;
            }
            return root.left == null && root.right == null;
        }
    }

    public static void main(String[] args) {
//        String[] nodes = {"5", "4", "8", "11", "null", "13", "4", "7", "2", "null", "null", "null", "1"};
        String[] nodes = {"null"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        int targetSum = 22;
        System.out.println(new Solution().hasPathSum(root, targetSum));
    }
}
