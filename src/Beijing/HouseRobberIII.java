package Beijing;
/*
https://leetcode-cn.com/problems/house-robber-iii/
 */

import java.util.HashMap;
import java.util.Map;

// 感觉自己就是个智障
public class HouseRobberIII {
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
            int select = root.val + L[1] + R[1];
            int noSelect = Math.max(L[0], L[1]) + Math.max(R[0], R[1]);
            return new int[]{select, noSelect};
        }
    }

    static class Solution1 {
        Map<TreeNode, Integer> select;
        Map<TreeNode, Integer> noSelect;

        public int rob(TreeNode root) {
            select = new HashMap<>();
            noSelect = new HashMap<>();
            dfs(root);
            return Math.max(select.getOrDefault(root, 0), noSelect.getOrDefault(root, 0));
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            dfs(root.right);
            select.put(root, root.val + noSelect.getOrDefault(root.left, 0) + noSelect.getOrDefault(root.right, 0));
            noSelect.put(root, Math.max(select.getOrDefault(root.left, 0), noSelect.getOrDefault(root.left, 0))
                    + Math.max(select.getOrDefault(root.right, 0), noSelect.getOrDefault(root.right, 0)));
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"3", "2", "3", "null", "3", "null", "1"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().rob(root));
    }
}
