package LeetCode;

/*
581. Shortest Unsorted Continuous Subarray
Easy

1911

91

Add to List

Share
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
 */
//又不是自己写的。。。。。
class ShortestUnsortedContinuousSubarraySolution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int begin = -1, end = -2, min = nums[nums.length - 1], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            //这个地方有坑！！！
//            end = max < nums[i] ? end : i;
            end = max > nums[i] ? i : end;
            min = Math.min(min, nums[nums.length - 1 - i]);
            //这个地方有坑！！！
//            begin = min > nums[nums.length - 1 - i] ? begin : nums.length - 1 - i;
            begin = min < nums[nums.length - 1 - i] ? nums.length - 1 - i : begin;
        }
        return end - begin + 1;
    }
}

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
//        int[] nums = {2, 6, 6, 4, 8, 10, 9, 9};
//        int[] nums = {2, 1};
//        int[] nums = {1, 2, 3, 4, 6, 5};
//        int[] nums = {1, 3, 2, 4, 5};
        int[] nums = {1, 2, 4, 5, 3};
        System.out.println(new ShortestUnsortedContinuousSubarraySolution().findUnsortedSubarray(nums));
    }
}
