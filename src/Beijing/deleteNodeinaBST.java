package Beijing;
/*
https://leetcode.cn/problems/delete-node-in-a-bst/
 */

// 自己写的，就是写法有点别扭
public class deleteNodeinaBST {
    static class Solution {
        private TreeNode dummyRoot;

        public TreeNode deleteNode(TreeNode root, int key) {
            dummyRoot = new TreeNode(-1);
            dummyRoot.left = root;
            search(dummyRoot, key, true);
            return dummyRoot.left;
        }

        private void search(TreeNode preRoot, int key, boolean isL) {
            TreeNode cur = isL ? preRoot.left : preRoot.right;
            if (cur == null) {
                return;
            }
            if (cur.val == key) {
                if (cur.left != null && cur.right != null) {
                    TreeNode Rl = getLeft(cur.right);
                    Rl.left = cur.left;
                    cur = cur.right;
                } else if (cur.left != null) {
                    cur = cur.left;
                } else if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur = null;
                }
                if (isL) {
                    preRoot.left = cur;
                } else {
                    preRoot.right = cur;
                }
            } else search(cur, key, cur.val >= key);
        }

        private TreeNode getLeft(TreeNode root) {
            if (root.left == null) {
                return root;
            }
            return getLeft(root.left);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"5", "3", "6", "2", "4", "null", "7"};
        int key = 0;
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        TreeNode ans = new Solution().deleteNode(root, key);
        new PrintTree().LevelPrintTree(ans);
    }
}
