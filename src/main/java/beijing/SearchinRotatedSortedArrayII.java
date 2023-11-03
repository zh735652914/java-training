package beijing;
/*
https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 */

// 看了答案才写出来，虽然知道是二分，但是各种情况的判断弄混了
public class SearchinRotatedSortedArrayII {
    static class Solution {
        public boolean search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                // 无法判断左右哪边有序
                if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                    left++;
                    right--;
                } else if (nums[left] <= nums[mid]) { // 左边有序
                    if (target >= nums[left] && target < nums[mid]) {
                        // 在左边
                        right = mid - 1;
                    } else {
                        // 不在左边
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
            return false;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {2, 5, 6, 0, 0, 1, 2};
//        int target = 3;
        int[] nums = {1, 0};
        int target = 0;
        System.out.println(new Solution().search(nums, target));
    }
}
