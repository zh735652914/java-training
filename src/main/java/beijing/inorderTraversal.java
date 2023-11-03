package beijing;
/*
https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */

import java.util.ArrayList;
import java.util.List;

public class inorderTraversal {
    static class Solution {
        List<Integer> ans;

        public List<Integer> inorderTraversal(TreeNode root) {
            ans = new ArrayList<>();
            backtrack(root);
            return ans;
        }

        private void backtrack(TreeNode root) {
            if (root == null) {
                return;
            }
            backtrack(root.left);
            ans.add(root.val);
            backtrack(root.right);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "null", "2", "3"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().inorderTraversal(root));
    }
}
