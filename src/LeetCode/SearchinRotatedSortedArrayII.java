package LeetCode;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
 */
/*
自己没写出来，一直超时，看了Discuss才写出来。。。
 */
class SearchinRotatedSortedArrayIISolution {
    public boolean search(int[] nums, int target) {
//        if (nums.length < 1) return false;
        int left = 0, right = nums.length - 1, mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[left] || nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right] || nums[mid] > nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                right--;
            }
        }
        return false;
    }
}

public class SearchinRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
//        int[] nums = {1, 1};
        int target = 2;
        SearchinRotatedSortedArrayIISolution SRSA = new SearchinRotatedSortedArrayIISolution();
        if (SRSA.search(nums, target)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
