package Beijing;
/*
https://leetcode-cn.com/problems/path-sum-iii/
 */

import java.util.HashMap;
import java.util.Map;

// （自己没写出来）前缀和，记录根节点开始到当前节点及以上所有节点的路径和，然后用根节点到当前路径的和减去target，查看是否在前缀和中
public class pathSumIII {
    static class Solution {
        Map<Integer, Integer> prefix;

        public int pathSum(TreeNode root, int targetSum) {
            prefix = new HashMap<>();
            prefix.put(0, 1);
            return dfs(root, targetSum, 0);
        }

        private int dfs(TreeNode root, int targetSum, int cur) {
            if (root == null) {
                return 0;
            }
            cur += root.val;
            int result = prefix.getOrDefault(cur - targetSum, 0);
            prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);
            result += dfs(root.left, targetSum, cur);
            result += dfs(root.right, targetSum, cur);
            prefix.put(cur, prefix.get(cur) - 1);
            return result;
        }
    }

    public static void main(String[] args) {
//        String[] node = {"10", "5", "-3", "3", "2", "null", "11", "3", "-2", "null", "1"};
//        int targetSum = 8;

        /*
        [5,4,8,11,null,13,4,7,2,null,null,5,1]
        22
         */
        String[] node = {"5", "4", "8", "11", "null", "13", "4", "7", "2", "null", "null", "5", "1"};
        int targetSum = 22;
        TreeNode root = new BuildTree().LevelBuildTree(node);
        System.out.println(new Solution().pathSum(root, targetSum));
    }
}
