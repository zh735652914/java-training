package LeetCode;
/*
268. Missing Number
Easy

1268

1676

Add to List

Share
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

//这题没什么好说的
class MissingNumberSolution {
    public int missingNumber(int[] nums) {
        int target = (1 + nums.length) * nums.length / 2;
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        return target - sum;
    }
}

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(new MissingNumberSolution().missingNumber(nums));
    }
}
