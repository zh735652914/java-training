package Beijing;
/*
https://leetcode.cn/problems/diameter-of-binary-tree/
 */

// 这题头条面过，我居然没写出来，如果写出来了，应该有offer的
public class diameterOfBinaryTree {
    static class Solution {
        private int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            ans = 0;
            dfs(root);
            return ans - 1;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int L = dfs(root.left);
            int R = dfs(root.right);
            ans = Math.max(L + R + 1, ans);
            return Math.max(L, R) + 1;
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "2", "3", "4", "5"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().diameterOfBinaryTree(root));
    }
}
