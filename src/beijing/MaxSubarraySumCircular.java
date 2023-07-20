package beijing;
/*
https://leetcode.cn/problems/maximum-sum-circular-subarray/
 */

/**
 * @author zhouhao
 * @date 2023/7/20 12:46
 */
public class MaxSubarraySumCircular {
    // 自己不会写
    static class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int preMax = nums[0], maxSum = nums[0];
            int preMin = nums[0], minSum = nums[0];
            int sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                preMax = Math.max(nums[i], preMax + nums[i]);
                maxSum = Math.max(maxSum, preMax);
                preMin = Math.min(nums[i], preMin + nums[i]);
                minSum = Math.min(minSum, preMin);
                sum += nums[i];
            }
            if (maxSum < 0) {
                return maxSum;
            } else {
                return Math.max(maxSum, sum - minSum);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2};
        System.out.println(new Solution().maxSubarraySumCircular(nums));
    }
}
