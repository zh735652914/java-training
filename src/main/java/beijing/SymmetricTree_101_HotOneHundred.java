package beijing;

/**
 * @author zhouhao
 * @date 2023/9/11 17:09
 */
public class SymmetricTree_101_HotOneHundred {
    // 还是不会
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSame(root.left, root.right);
        }

        private boolean isSame(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left != null && right == null || left == null && right != null || left.val != right.val) {
                return false;
            }
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        }
    }

    public static void main(String[] args) {
        String nodes = "[1,2,2,3,4,4,3]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().isSymmetric(root));
    }
}
