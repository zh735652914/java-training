package Beijing;
/*
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */

// 怎么自己又不会写了
public class LowestCommonAncestorofaBinaryTree_236_topInterviewList {
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
            } else return R;
        }
    }

    public static void main(String[] args) {
        String nodes = "[3,5,1,6,2,0,8,null,null,7,4]";
        int p = 5, q = 1;
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        TreeNode ans = new Solution().lowestCommonAncestor(root, findNode(root, p), findNode(root, q));
        System.out.println(ans.val);
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
