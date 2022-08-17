package Beijing;
/*
https://leetcode.cn/problems/deepest-leaves-sum/
 */

import java.util.HashMap;
import java.util.Map;

public class deepestLeavesSum {
    // 解析写的更好
    static class Solution {
        private int maxLevel, sum;

        public int deepestLeavesSum(TreeNode root) {
            maxLevel = -1;
            sum = 0;
            visitTree(root, 0);
            return sum;
        }

        private void visitTree(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (level > maxLevel) {
                sum = root.val;
                maxLevel = level;
            } else if (level == maxLevel) {
                sum += root.val;
            }
            visitTree(root.left, level + 1);
            visitTree(root.right, level + 1);
        }
    }

    // 自己写的，效率不太高？
    static class Solution0 {
        private Map<Integer, Integer> map;
        private int deepest;

        public int deepestLeavesSum(TreeNode root) {
            map = new HashMap<>();
            deepest = 0;
            visitTree(root, 1);
            return map.get(deepest);
        }

        private void visitTree(TreeNode root, int deep) {
            if (root.left == null && root.right == null) {
                map.put(deep, map.getOrDefault(deep, 0) + root.val);
                deepest = Math.max(deep, deepest);
                return;
            }
            if (root.left != null) {
                visitTree(root.left, deep + 1);
            }
            if (root.right != null) {
                visitTree(root.right, deep + 1);
            }
        }
    }

    public static void main(String[] args) {
        String nodes = "[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().deepestLeavesSum(root));
    }
}
