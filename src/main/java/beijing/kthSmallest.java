package beijing;
/*
https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */

public class kthSmallest {
    static class Solution {
        private int count, ans;

        public int kthSmallest(TreeNode root, int k) {
            count = 0;
            ans = -1;
            inorderVisit(root, k);
            return ans;
        }

        private void inorderVisit(TreeNode root, int k) {
            if (root == null) {
                return;
            }
            inorderVisit(root.left, k);
            count++;
            if (count == k) {
                ans = root.val;
            }
            inorderVisit(root.right, k);
        }
    }

    public static void main(String[] args) {
        String[] nodes = {"5", "3", "6", "2", "4", "null", "null", "1"};
        TreeNode rooot = new BuildTree().LevelBuildTree(nodes);
        int k = 3;
        System.out.println(new Solution().kthSmallest(rooot, k));
    }
}
