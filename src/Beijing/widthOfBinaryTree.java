package Beijing;
/*
https://leetcode.cn/problems/maximum-width-of-binary-tree/
 */

import java.util.ArrayList;
import java.util.List;

// 自己没写出来，看了评论才知道怎么写
public class widthOfBinaryTree {
    static class Solution {
        private int maxWidth = 0;

        public int widthOfBinaryTree(TreeNode root) {
            dfs(root, 1, 1, new ArrayList<>());
            return maxWidth;
        }

        private void dfs(TreeNode root, int level, int index, List<Integer> leftNode) {
            if (root == null) {
                return;
            }
            if (leftNode.size() < level) {
                leftNode.add(index);
            }
            maxWidth = Math.max(maxWidth, index - leftNode.get(level - 1) + 1);
            dfs(root.left, level + 1, 2 * index, leftNode);
            dfs(root.right, level + 1, 2 * index + 1, leftNode);
        }
    }

    public static void main(String[] args) {
        String nodes = "[1,3,2,5,3,null,9]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().widthOfBinaryTree(root));
    }
}
