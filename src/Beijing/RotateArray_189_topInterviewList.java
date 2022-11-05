package Beijing;
/*
https://leetcode.cn/problems/rotate-array/
 */

public class RotateArray_189_topInterviewList {
    // 数组翻转很重要！！！
    static class Solution {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            int tmp;
            while (start < end) {
                tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7}; // 5,6,7,1,2,3,4
        int k = 3;
        new Solution().rotate(nums, k);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
