package beijing;
/*
https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/
 */

/**
 * @author zhouhao
 * @date 2023/3/16 23:14
 */
public class MaxPathSum_2 {
    // 第五次了，还是得看解析
    static class Solution {
        private int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            backtrack(root);
            return ans;
        }

        private int backtrack(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int L = Math.max(backtrack(root.left), 0);
            int R = Math.max(backtrack(root.right), 0);
            ans = Math.max(ans, L + R + root.val);
            return Math.max(L, R) + root.val;
        }
    }

    public static void main(String[] args) {
        String nodes = "[-10,9,20,null,null,15,7]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().maxPathSum(root));
    }
}
