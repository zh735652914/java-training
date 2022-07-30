package Beijing;

// 很重要！！！
public class lowestCommonAncestorofaBinaryTree_236 {
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (root == p || root == q) {
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
        String nodes = "[6,2,8,0,4,7,9,null,null,3,5]";
        int p = 2, q = 8;
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().lowestCommonAncestor(root, findNode(root, p), findNode(root, q)).val);
    }

    private static TreeNode findNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode left = findNode(root.left, val);
        TreeNode right = findNode(root.right, val);
        return left != null ? left : right;
    }
}
