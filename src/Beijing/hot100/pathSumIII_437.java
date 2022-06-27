package Beijing.hot100;
/*
https://leetcode.cn/problems/path-sum-iii/
 */

import Beijing.BuildTree;
import Beijing.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 第二次还是没有写出来，得用Map存储路径和
public class pathSumIII_437 {
    static class Solution {
        private int count;
        private int targetSum;

        public int pathSum(TreeNode root, int targetSum) {
            count = 0;
            this.targetSum = targetSum;
            Map<Integer, Integer> pastSum = new HashMap<>();
            pastSum.put(0, 1);
            dfs(root, 0, pastSum);
            return count;
        }

        private void dfs(TreeNode root, int sum, Map<Integer, Integer> pastSum) {
            if (root == null) {
                return;
            }
            sum += root.val;
            count += pastSum.getOrDefault(sum - targetSum, 0);
            pastSum.put(sum, pastSum.getOrDefault(sum, 0) + 1);
            dfs(root.left, sum, pastSum);
            dfs(root.right, sum, pastSum);
            pastSum.put(sum, pastSum.get(sum) - 1);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "null", "2", "null", "3", "null", "4", "null", "5"};
        int targetSum = 3;
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().pathSum(root, targetSum));
    }
}
