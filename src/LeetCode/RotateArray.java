package LeetCode;
/*
189. Rotate Array
Easy

1925

707

Add to List

Share
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 */

//自己没想到这种算法，，，
class RotateArraySolution {
    public void rotate(int[] nums, int k) {
        if (k >= nums.length) k = k % nums.length;
        if (k == 0) return;
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, 0, nums.length - 1);

        //做自己测试用
        Output(nums);
    }

    private void reverse(int[] nums, int start, int end) {
        int tmp = nums[start];
        while (start < end) {
            nums[start++] = nums[end];
            nums[end--] = tmp;
            tmp = nums[start];
        }
    }

    private void Output(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        new RotateArraySolution().rotate(nums, k);
    }
}
