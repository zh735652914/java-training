package beijing;

public class isSymmetric {
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSame(root.left, root.right);
        }

        private boolean isSame(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                if (A != null) {
                    return false;
                }
                return B == null;
            }
            if (A.val != B.val) {
                return false;
            }
            return isSame(A.left, B.right) && isSame(A.right, B.left);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "2", "2", "null", "3", "null", "3"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().isSymmetric(root));
    }
}
