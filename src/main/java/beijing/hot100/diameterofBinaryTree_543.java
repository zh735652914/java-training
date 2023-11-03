package beijing.hot100;
/*
https://leetcode.cn/problems/diameter-of-binary-tree/
 */

import beijing.BuildTree;
import beijing.TreeNode;

public class diameterofBinaryTree_543 {
    // 这题还是要多看看
    static class Solution {
        private int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            ans = 0;
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int L = dfs(root.left);
            int R = dfs(root.right);
            ans = Math.max(ans, L + R);
            return Math.max(L, R) + 1;
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "2", "3", "4", "5"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().diameterOfBinaryTree(root));
    }
}
