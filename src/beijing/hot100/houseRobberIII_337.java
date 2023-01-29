package beijing.hot100;
/*
https://leetcode.cn/problems/house-robber-iii/
 */

import beijing.BuildTree;
import beijing.TreeNode;

// 第二次，自己还是不会写
public class houseRobberIII_337 {
    static class Solution {
        public int rob(TreeNode root) {
            int[] ans = dfs(root);
            return Math.max(ans[0], ans[1]);
        }

        private int[] dfs(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }
            int[] L = dfs(root.left);
            int[] R = dfs(root.right);
            int rob = root.val + L[0] + R[0];
            int noRob = Math.max(L[1], L[0]) + Math.max(R[1], R[0]);
            return new int[]{noRob, rob};
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"3", "2", "3", "null", "3", "null", "1"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().rob(root));
    }
}
