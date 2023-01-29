package beijing;
/*
https://leetcode.cn/problems/validate-binary-search-tree/
 */

public class validateBinarySearchTree_98_topInterviewList {
    static class Solution {
        private long pre = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            // 记住：中序遍历为升序列！！！
            if (root == null) {
                return true;
            }
            if (!isValidBST(root.left)) {
                return false;
            }
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            return isValidBST(root.right);
        }
    }

    public static void main(String[] args) {
        String nodes = "[5,4,6,null,null,3,7]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().isValidBST(root));
    }
}
