package leetcode;
/*
230. Kth Smallest Element in a BST
Medium

1666

53

Add to List

Share
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
How would you optimize the kthSmallest routine?
 */


public class KthSmallestElementBST {
    static class KthSmallestElementBSTSolution {
        private int Kth = 0;
        private int K = 0;
        private int ans = 0;

        public int kthSmallest(TreeNode root, int k) {
            this.K = k;
            backtrack(root);
            return ans;
        }

        private void backtrack(TreeNode root) {
            if (root == null) {
                return;
            }
            backtrack(root.left);
            Kth++;
            if (K == Kth) {
                ans = root.val;
                return;
            }
            backtrack(root.right);
        }
    }

    public static void main(String[] args) {
        String[] s = {"3", "1", "4", "null", "2"};
//        String[] s = {"5", "3", "6", "2", "4", "null", "null", "1"};
        TreeNode root = new BuildTree().LevelBuild(s);
        int k = 1;
        System.out.println(new KthSmallestElementBSTSolution().kthSmallest(root, k));
    }
}
