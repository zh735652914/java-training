package Beijing;
/*
https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */

public class flatten {
    static class Solution {
        // 自己没写出来
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten(root.left);
            flatten(root.right);
            TreeNode node = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null) {
                root = root.right;
            }
            root.right = node;
        }
    }

    public static void main(String[] args) {
        String nodes = "[1,2,5,3,4,null,6]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        new Solution().flatten(root);
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
    }
}
