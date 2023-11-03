package beijing;
/*
https://leetcode.cn/problems/validate-binary-search-tree/
 */

/**
 * @author zhouhao
 * @date 2023/8/19 14:31
 */
public class ValidateBinarySearchTree_98_HotOneHundred {
    // 面试中遇到过
    static class Solution {
        private long preVal;
        private boolean isValid;

        public boolean isValidBST(TreeNode root) {
            preVal = Long.MIN_VALUE;
            isValid = true;
            inorderVisit(root);
            return isValid;
        }

        private void inorderVisit(TreeNode root) {
            if (root == null || !isValid) {
                return;
            }
            inorderVisit(root.left);
            if (root.val <= preVal) {
                isValid = false;
                return;
            }
            preVal = root.val;
            inorderVisit(root.right);
        }
    }

    public static void main(String[] args) {
        String nodes = "[2,1,3]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().isValidBST(root));
    }
}
