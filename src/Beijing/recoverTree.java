package Beijing;
/*
https://leetcode-cn.com/problems/recover-binary-search-tree/
 */

public class recoverTree {
    // 又是自己没想出来的写法
    static class Solution {
        private TreeNode pre, A, B;

        public void recoverTree(TreeNode root) {
            inOrder(root);
            int tmp = A.val;
            A.val = B.val;
            B.val = tmp;
        }

        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            if (pre != null && pre.val >= root.val) {
                if (A == null) {
                    A = pre;
                }
                B = root;
            }
            pre = root;
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"1", "3", "null", "null", "2"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        new Solution().recoverTree(root);
        new PrintTree().LevelPrintTree(root);
    }
}
