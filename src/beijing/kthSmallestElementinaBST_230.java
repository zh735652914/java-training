package beijing;
/*
https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 */

// 考树的性质和搜索
public class kthSmallestElementinaBST_230 {
    static class Solution {
        private int ans, count, k;

        public int kthSmallest(TreeNode root, int k) {
            ans = -1;
            count = 0;
            this.k = k;
            inOrderVisited(root);
            return ans;
        }

        private void inOrderVisited(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrderVisited(root.left);
            count++;
            if (count == k) {
                ans = root.val;
                return;
            }
            inOrderVisited(root.right);
        }
    }

    public static void main(String[] args) {
        String nodes = "[5,3,6,2,4,null,null,1]";
        int k = 3;
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().kthSmallest(root, k));
    }
}
