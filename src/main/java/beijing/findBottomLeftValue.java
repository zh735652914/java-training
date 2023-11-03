package beijing;
/*
https://leetcode.cn/problems/find-bottom-left-tree-value/
 */

// 自己写的dfs
public class findBottomLeftValue {
    static class Solution {
        private int ans;
        private int ansLevel;

        public int findBottomLeftValue(TreeNode root) {
            ans = root.val;
            ansLevel = 1;
            dfs(root, 1);
            return ans;
        }

        private void dfs(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            dfs(root.left, level + 1);
            if (level > ansLevel) {
                ansLevel = level;
                ans = root.val;
            }
            dfs(root.right, level + 1);
        }
    }

    public static void main(String[] args) {
        String[] nods = {"1", "2", "3", "4", "null", "5", "6", "null", "null", "7"};
        TreeNode root = new BuildTree().LevelBuildTree(nods);
        System.out.println(new Solution().findBottomLeftValue(root));
    }
}
