package Beijing;
/*
https://leetcode-cn.com/problems/count-complete-tree-nodes/
 */

public class CountCompleteTreeNodes {
    static class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    static class Solution0 {
        private int count;

        public int countNodes(TreeNode root) {
            count = 0;
            visit(root);
            return count;
        }

        private void visit(TreeNode root) {
            if (root == null) {
                return;
            }
            count++;
            visit(root.left);
            visit(root.right);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "2", "3", "4", "5", "6"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().countNodes(root));
    }
}
