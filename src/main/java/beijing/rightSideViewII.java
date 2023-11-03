package beijing;
/*
https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */

import java.util.ArrayList;
import java.util.List;

public class rightSideViewII {
    static class Solution {
        private int level;
        private List<Integer> ans;

        public List<Integer> rightSideView(TreeNode root) {
            level = 1;
            ans = new ArrayList<>();
            visit(root, 1);
            return ans;
        }

        private void visit(TreeNode root, int deep) {
            if (root == null) {
                return;
            }
            if (deep == level) {
                level++;
                ans.add(root.val);
            }
            visit(root.right, deep + 1);
            visit(root.left, deep + 1);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "2", "3", "null", "5", "null", "4"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().rightSideView(root));
    }
}
