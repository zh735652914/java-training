package beijing;
/*
https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 */

// 很重要！自己没写出来
public class binaryTreeMaximumPathSum_124 {
    static class Solution {
        private int ans;

        public int maxPathSum(TreeNode root) {
            ans = Integer.MIN_VALUE;
            pathSum(root);
            return ans;
        }

        private int pathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int L = Math.max(0, pathSum(root.left));
            int R = Math.max(0, pathSum(root.right));
            ans = Math.max(ans, root.val + L + R);
            return Math.max(L, R) + root.val;
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"-10", "9", "20", "null", "null", "15", "7"};
//        String[] nodes = {"1", "-2", "3"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().maxPathSum(root));
    }
}
