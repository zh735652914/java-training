package Beijing;
/*
https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */

public class sortedArrayToBST {
    // 这题也很简单
    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return backtrack(nums, 0, nums.length - 1);
        }

        private TreeNode backtrack(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = backtrack(nums, start, mid - 1);
            root.right = backtrack(nums, mid + 1, end);
            return root;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = new Solution().sortedArrayToBST(nums);
        new PrintTree().LevelPrintTree(root);
    }
}
