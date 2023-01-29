package leetcode;

/*
162. Find Peak Element
Medium

1186

1666

Add to List

Share
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2,
             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.
 */
//不知道这题想干嘛。。。
class FindPeakElementSolution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;
        int peak = 0;
        for (int i = 0; i < nums.length; i++) {
//            if ((i == 0 && nums[i + 1] < nums[i]) || ((i + 1) >= nums.length && nums[i] > nums[i - 1])) return i;
            if (i == 0) {
                if (nums[i + 1] < nums[i]) return i;
                continue;
            }
            if (i + 1 >= nums.length) {
                if (nums[i - 1] < nums[i]) return i;
                continue;
            }
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peak = i;
                break;
            }
        }
        return peak;
    }
}

public class FindPeakElement {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};//3
//        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int[] nums = {0, 1, 3};
        System.out.println(new FindPeakElementSolution().findPeakElement(nums));
    }
}
