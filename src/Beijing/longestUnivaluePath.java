package Beijing;
/*
https://leetcode.cn/problems/longest-univalue-path/
 */

// 自己没写出来
public class longestUnivaluePath {
    static class Solution {
        private int ans;

        public int longestUnivaluePath(TreeNode root) {
            ans = 0;
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            int L = 0, R = 0;
            if (root.left != null && root.left.val == root.val) {
                L = left + 1;
            }
            if (root.right != null && root.right.val == root.val) {
                R = right + 1;
            }
            ans = Math.max(ans, L + R);
            return Math.max(L, R);
        }
    }

    public static void main(String[] args) {
        String nodes = "[1,4,5,4,4,null,5]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().longestUnivaluePath(root));
    }
}
