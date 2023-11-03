package beijing;
/*
https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 */

public class binaryTreeMaximumPathSum_124_topInterviewList {
    // 【重要】第四次了，自己还是不会
    static class Solution {
        private int ans;

        public int maxPathSum(TreeNode root) {
            ans = Integer.MIN_VALUE;
            backtrack(root);
            return ans;
        }

        private int backtrack(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int L = Math.max(0, backtrack(root.left));
            int R = Math.max(0, backtrack(root.right));
            ans = Math.max(ans, root.val + L + R);
            return root.val + Math.max(L, R);
        }
    }

    public static void main(String[] args) {
        String nodes = "[-10,9,20,null,null,15,7]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().maxPathSum(root));
    }
}
