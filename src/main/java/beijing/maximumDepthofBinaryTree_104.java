package beijing;
/*
https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */

// 第二次写，这个写法简洁一些
public class maximumDepthofBinaryTree_104 {
    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    public static void main(String[] args) {
        String nodes = "[3,9,20,null,null,15,7]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().maxDepth(root));
    }
}
