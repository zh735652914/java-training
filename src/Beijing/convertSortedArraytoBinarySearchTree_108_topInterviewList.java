package Beijing;
/*
https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 */

public class convertSortedArraytoBinarySearchTree_108_topInterviewList {
    // 不要想复杂就行
    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return constructTree(nums, 0, nums.length - 1);
        }

        private TreeNode constructTree(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = constructTree(nums, start, mid - 1);
            root.right = constructTree(nums, mid + 1, end);
            return root;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        new PrintTree().LevelPrintTree(new Solution().sortedArrayToBST(nums));
    }
}
