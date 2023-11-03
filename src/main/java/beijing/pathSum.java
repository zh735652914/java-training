package beijing;
/*
https://leetcode-cn.com/problems/path-sum-ii/
 */

import java.util.ArrayList;
import java.util.List;

public class pathSum {
    static class Solution0 {
        List<List<Integer>> ans;

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            ans = new ArrayList<>();
            DFS(root, targetSum, new ArrayList<>());
            return ans;
        }

        private void DFS(TreeNode root, int targetSum, List<Integer> path) {
            if (root == null) {
                return;
            }
            path.add(root.val);
            if (root.val == targetSum && isLeaf(root)) {
                ans.add(path);
                return;
            }
            targetSum -= root.val;
            DFS(root.left, targetSum, new ArrayList<>(path));
            DFS(root.right, targetSum, new ArrayList<>(path));
        }

        private boolean isLeaf(TreeNode root) {
            if (root == null) {
                return false;
            }
            return root.left == null && root.right == null;
        }
    }

    static class Solution {
        List<List<Integer>> ans;

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            ans = new ArrayList<>();
            DFS(root, targetSum, new ArrayList<>());
            return ans;
        }

        private void DFS(TreeNode root, int targetSum, List<Integer> path) {
            if (root == null) {
                return;
            }
            path.add(root.val);
            if (root.val == targetSum && isLeaf(root)) {
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
            targetSum -= root.val;
            DFS(root.left, targetSum, path);
            DFS(root.right, targetSum, path);
            path.remove(path.size() - 1);
        }

        private boolean isLeaf(TreeNode root) {
            if (root == null) {
                return false;
            }
            return root.left == null && root.right == null;
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"5", "4", "8", "11", "null", "13", "4", "7", "2", "null", "null", "5", "1"};
        int targetSum = 22;
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().pathSum(root, targetSum));
    }
}
