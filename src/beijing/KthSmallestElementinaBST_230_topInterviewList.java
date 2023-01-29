package beijing;
/*
https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 */

public class KthSmallestElementinaBST_230_topInterviewList {
    // 记住中序遍历就行
    static class Solution {
        private int count = 0;
        private int ans;
        private int k;

        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            inOrderVisit(root);
            return ans;
        }

        private void inOrderVisit(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrderVisit(root.left);
            count++;
            if (count == k) {
                ans = root.val;
                return;
            }
            inOrderVisit(root.right);
        }
    }

    public static void main(String[] args) {
        String nodes = "[5,3,6,2,4,null,null,1]";
        int k = 3;
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        System.out.println(new Solution().kthSmallest(root, k));
    }
}
