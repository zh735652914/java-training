package Beijing;
/*
https://leetcode.cn/problems/symmetric-tree/
 */

public class symmetricTree_101_topInterviewList {
    // 自己没写出来
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isSame(root.left, root.right);
        }

        private boolean isSame(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        }
    }

    public static void main(String[] args) {
        String nodes = "[1,2,2,null,3,null,3]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().isSymmetric(root));
    }
}
