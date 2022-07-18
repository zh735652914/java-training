package Beijing;
/*
https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 */

// 第三次写了，还没完全写出来，很重要！
public class binaryTreeMaximumPathSum_124_Second {
    static class Solution {
        private int ans;

        public int maxPathSum(TreeNode root) {
            ans = Integer.MIN_VALUE;
            getSum(root);
            return ans;
        }

        private int getSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(0, getSum(root.left));
            int right = Math.max(0, getSum(root.right));
            ans = Math.max(ans, left + right + root.val);
            return root.val + Math.max(left, right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new BuildTree().LevelBuildTree("[9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6]");
        System.out.println(new Solution().maxPathSum(root));
    }
}
