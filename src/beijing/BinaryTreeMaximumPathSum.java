package beijing;
/*
https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */

public class BinaryTreeMaximumPathSum {
    // 难受，又是不会的一题，其实不难
    static class Solution {
        private int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            getMax(root);
            return ans;
        }

        private int getMax(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(0, getMax(root.left));
            int right = Math.max(0, getMax(root.right));
            ans = Math.max(ans, root.val + left + right);
            return Math.max(left, right) + root.val;
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"-10", "9", "20", "null", "null", "15", "7"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().maxPathSum(root));
    }
}
