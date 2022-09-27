package Beijing;
/*
https://leetcode.cn/problems/binary-tree-inorder-traversal/
 */

import java.util.ArrayList;
import java.util.List;

// 这题要是面试没写出来的话，那直接g了
public class binaryTreeInorderTraversal_94_topInterviewList {
    static class Solution {
        private List<Integer> ans;

        public List<Integer> inorderTraversal(TreeNode root) {
            ans = new ArrayList<>();
            inOrderVisit(root);
            return ans;
        }

        private void inOrderVisit(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrderVisit(root.left);
            ans.add(root.val);
            inOrderVisit(root.right);
        }
    }

    public static void main(String[] args) {
        String nodes = "[1,null,2,3]";
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().inorderTraversal(root));
    }
}
