package beijing.hot100;

import beijing.BuildTree;
import beijing.TreeNode;

public class lowestCommonAncestorofaBinaryTree_236 {
    // 情况想清楚就很简单，不过还是很典型的题目
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (root.val == p.val || root.val == q.val) {
                return root;
            }
            TreeNode L = lowestCommonAncestor(root.left, p, q);
            TreeNode R = lowestCommonAncestor(root.right, p, q);
            if (L != null && R != null) {
                return root;
            } else if (L != null) {
                return L;
            } else {
                return R;
            }
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"3", "5", "1", "6", "2", "0", "8", "null", "null", "7", "4"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        TreeNode p = dfs(5, root);
        TreeNode q = dfs(1, root);
        TreeNode ans = new Solution().lowestCommonAncestor(root, p, q);
        System.out.println(ans.val);
    }

    private static TreeNode dfs(int val, TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode L = dfs(val, root.left);
        TreeNode R = dfs(val, root.right);
        return L == null ? R : L;
    }
}
