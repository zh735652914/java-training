package leetcode;
/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */

import java.util.Arrays;

class MajorityElementSolution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1, p = nums[0], major = nums[0], max = count;
        for (int i = 1; i < nums.length; i++) {
            if (p == nums[i]) {
                count++;
                if (max < count) {
                    max = count;
                    major = p;
                }
            } else {
                count = 1;
                p = nums[i];
            }
        }
        return major;
    }
}

public class MajorityElement {
    public static void main(String[] args) {
//        int[] nums = {2, 2, 1, 1, 1, 2, 2};
//        int[] nums = {2, 2, 1, 3, 3, 5, 1, 4, 6, 7, 3};
        int[] nums = {2, 2, 1, 3, 3, 1, 4, 4, 1, 5, 5};
        MajorityElementSolution majorityElementSolution = new MajorityElementSolution();
        System.out.println(majorityElementSolution.majorityElement(nums));
    }
}
