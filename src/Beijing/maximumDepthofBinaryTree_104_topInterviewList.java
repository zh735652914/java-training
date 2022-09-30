package Beijing;
/*
https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */

public class maximumDepthofBinaryTree_104_topInterviewList {
    // 很简单的题目
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
