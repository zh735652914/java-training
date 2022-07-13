package Beijing;
/*
https://leetcode.cn/problems/search-in-rotated-sorted-array/
 */

// 第四次了，还是没完全写出来，写出来了一半
public class searchinRotatedSortedArray_33 {
    static class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[left] <= nums[mid]) {
                    if (target >= nums[left] && target <= nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (target >= nums[mid] && target <= nums[right]) {
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
        int[] nums = {5, 1, 2, 3, 4};
        int target = 1;
        System.out.println(new Solution().search(nums, target));
    }
}
