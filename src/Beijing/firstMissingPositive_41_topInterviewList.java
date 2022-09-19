package Beijing;
/*
https://leetcode.cn/problems/first-missing-positive/
 */

public class firstMissingPositive_41_topInterviewList {
    // 想到思路了，但是细节没写出来，很魔鬼
    static class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= 0) {
                    nums[i] = nums.length + 1;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                int x = Math.abs(nums[i]) - 1;
                if (x >= 0 && x < nums.length) {
                    nums[x] = -Math.abs(nums[x]);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(new Solution().firstMissingPositive(nums));
    }
}
