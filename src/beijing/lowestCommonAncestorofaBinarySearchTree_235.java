package beijing;
/*
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */

// 第二次，自己不会写了
public class lowestCommonAncestorofaBinarySearchTree_235 {
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (true) {
                // 因为p和q确定在树中，所以root不会为空
//                if (root == null) {
//                    break;
//                }
                if (root.val < p.val && root.val < q.val) {
                    root = root.right;
                } else if (root.val > p.val && root.val > q.val) {
                    root = root.left;
                } else {
                    break;
                }
            }
            return root;
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
