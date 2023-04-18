package beijing;
/*
https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/
 */

/**
 * @author zhouhao
 * @date 2023/4/18 12:58
 */
public class MaxAncestorDiff {
    // 这题是mid难度？？？？
    static class Solution {
        private int ans;

        public int maxAncestorDiff(TreeNode root) {
            ans = 0;
            backtrack(root, root.val, root.val);
            return ans;
        }

        private void backtrack(TreeNode root, int max, int min) {
            if (root == null) {
                return;
            }
            max = Math.max(root.val, max);
            min = Math.min(root.val, min);
            ans = Math.max(ans, max - min);
            backtrack(root.left, max, min);
            backtrack(root.right, max, min);
        }
    }

    public static void main(String[] args) {
        String nodes = "[8,3,10,1,6,null,14,null,null,4,7,13]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().maxAncestorDiff(root));
    }
}
