package beijing.hot100;
/*
https://leetcode.cn/problems/search-in-rotated-sorted-array/
 */

public class searchinRotatedSortedArray_33 {
    static class Solution {
        public int search(int[] nums, int target) {
            /*
            判断哪边有序
             */
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] >= nums[left]) {   // 这个等于很重要！！可能是因为向下取整的原因
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
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
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int target = 0;
        int[] nums = {3, 1};
        int target = 1;
        System.out.println(new Solution().search(nums, target));
    }
}
