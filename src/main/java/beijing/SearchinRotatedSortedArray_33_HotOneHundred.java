package beijing;
/*
https://leetcode.cn/problems/search-in-rotated-sorted-array/
 */

/**
 * @author zhouhao
 * @date 2023/4/28 12:49
 */

// 边界条件要考虑一下
public class SearchinRotatedSortedArray_33_HotOneHundred {
    static class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] >= nums[left]) { // 这个等号很重要
                    // 左边有序
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    // 右边有序
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 1;
        System.out.println(new Solution().search(nums, target));
    }
}
