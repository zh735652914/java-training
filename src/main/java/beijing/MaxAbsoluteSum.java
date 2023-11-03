package beijing;
/*
https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/
 */

/**
 * @author zhouhao
 * @date 2023/8/8 12:51
 */
public class MaxAbsoluteSum {
    // 这题很重要，求子数组最大和
    static class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int maxValue = nums[0], minValue = nums[0];
            int sum1 = nums[0], sum2 = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum1 = Math.max(nums[i], sum1 + nums[i]);
                maxValue = Math.max(maxValue, sum1);
                sum2 = Math.min(nums[i], sum2 + nums[i]);
                minValue = Math.min(minValue, sum2);
            }
            return Math.max(maxValue, -minValue);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -3, 2, 3, -4};
        System.out.println(new Solution().maxAbsoluteSum(nums));
    }
}
