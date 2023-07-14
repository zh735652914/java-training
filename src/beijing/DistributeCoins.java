package beijing;
/*
https://leetcode.cn/problems/distribute-coins-in-binary-tree/
 */

/**
 * @author zhouhao
 * @date 2023/7/14 11:38
 */
public class DistributeCoins {
    // 看了解析才写出来
    static class Solution {
        private int moves = 0;

        public int distributeCoins(TreeNode root) {
            dfs(root);
            return moves;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            moves += Math.abs(left) + Math.abs(right);
            return left + right + root.val - 1;
        }
    }

    public static void main(String[] args) {
        String nodes = "[3,0,0]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().distributeCoins(root));
    }
}
