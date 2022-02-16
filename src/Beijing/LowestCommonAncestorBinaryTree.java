package Beijing;
/*
https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */

public class LowestCommonAncestorBinaryTree {
    // 这题一定要多看看！
    static class Solution {
        private TreeNode ans;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            ans = root;
            dfs(root, p, q);
            return ans;
        }

        private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return false;
            }
            boolean L = dfs(root.left, p, q);
            boolean R = dfs(root.right, p, q);
            if ((L && R) || (root.val == p.val || root.val == q.val) && (L || R)) {
                ans = root;
            }
            return L || R || (root.val == p.val || root.val == q.val);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"3", "5", "1", "6", "2", "0", "8", "null", "null", "7", "4"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        int a = 5, b = 1;
        TreeNode p = test(root, a);
        TreeNode q = test(root, b);
        System.out.println(new Solution().lowestCommonAncestor(root, p, q).val);
    }

    private static TreeNode test(TreeNode root, int x) {
        if (root == null) {
            return root;
        }
        if (x == root.val) {
            return root;
        }
        TreeNode L = test(root.left, x);
        TreeNode R = test(root.right, x);
        return L != null ? L : R;
    }
}
