package Beijing;
/*
https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */

public class lowestCommonAncestor {
    // 要利用二叉搜索树的性质
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode ancestor = root;
            while (true) {
                if (ancestor.val > p.val && ancestor.val > q.val) {
                    ancestor = ancestor.left;
                } else if (ancestor.val < p.val && ancestor.val < q.val) {
                    ancestor = ancestor.right;
                } else {
                    break;
                }
            }
            return ancestor;
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"6", "2", "8", "0", "4", "7", "9", "null", "null", "3", "5"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        int a = 2, b = 8;
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
