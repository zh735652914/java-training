package beijing;
/*
https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

public class searchRange {
    // 这题没有想象中的那么简单
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int LBorder = findTarget(nums, target, true);
            int RBorder = findTarget(nums, target, false) - 1;
            if (LBorder <= RBorder && LBorder >= 0 && RBorder < nums.length && nums[LBorder] == target && nums[RBorder] == target) {
                return new int[]{LBorder, RBorder};
            }
            return new int[]{-1, -1};
        }

        private int findTarget(int[] nums, int target, boolean L) {
            int left = 0, right = nums.length - 1;
            int mid = 0;
            int border = nums.length;
            // 左闭右开区间
            while (left <= right) {
                mid = left + ((right - left) >> 1);
                if (nums[mid] > target || (L && nums[mid] >= target)) {
                    border = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return border;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        int[] ans = new Solution().searchRange(nums, target);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
        System.out.println();
    }
}
