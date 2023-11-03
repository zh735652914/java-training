package beijing;
/*
https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */

import java.util.ArrayList;
import java.util.List;

public class preorderTraversal {
    static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            visit(root, ans);
            return ans;
        }

        private void visit(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return;
            }
            ans.add(root.val);
            visit(root.left, ans);
            visit(root.right, ans);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "null", "2", "3"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().preorderTraversal(root));
    }
}
