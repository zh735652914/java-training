package beijing;
/*
https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */

import java.util.ArrayList;
import java.util.List;

public class postorderTraversal {
    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            visit(root, ans);
            return ans;
        }

        private void visit(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return;
            }
            visit(root.left, ans);
            visit(root.right, ans);
            ans.add(root.val);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "null", "2", "3"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().postorderTraversal(root));
    }
}
