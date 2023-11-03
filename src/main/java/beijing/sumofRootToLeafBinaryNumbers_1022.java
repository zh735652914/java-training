package beijing;
/*
https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 */

public class sumofRootToLeafBinaryNumbers_1022 {
    static class Solution {
        private int ans;

        public int sumRootToLeaf(TreeNode root) {
            ans = 0;
            if (root == null) {
                return ans;
            }
            dfs(root, 0);
            return ans;
        }

        private void dfs(TreeNode root, int sum) {
            sum <<= 1;
            sum += root.val;
            if (root.left == null && root.right == null) {
                ans += sum;
                return;
            }
            if (root.left != null) {
                dfs(root.left, sum);
            }
            if (root.right != null) {
                dfs(root.right, sum);
            }
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "0", "1", "0", "1", "0", "1"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().sumRootToLeaf(root));
    }
}
