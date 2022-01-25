package Beijing;
/*
https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */

public class sumNumbers {
    // 这是别人写的
    static class Solution {
        private int sum;

        public int sumNumbers(TreeNode root) {
            sum = 0;
            dfs(root, 0);
            return sum;
        }

        private void dfs(TreeNode root, int num) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                sum += 10 * num + root.val;
            }
            dfs(root.left, 10 * num + root.val);
            dfs(root.right, 10 * num + root.val);
        }
    }

    // 自己写的，不够优美
    static class Solution0 {
        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return root.val;
            }
            return dfs(root.left, root.val) + dfs(root.right, root.val);
        }

        private int dfs(TreeNode root, int num) {
            if (root == null) {
                return 0;
            }
            num *= 10;
            num += root.val;
            if (root.left == null && root.right == null) {
                return num;
            }
            return dfs(root.left, num) + dfs(root.right, num);
        }
    }

    public static void main(String[] args) {
        String nodes = "[4]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().sumNumbers(root));
    }
}
