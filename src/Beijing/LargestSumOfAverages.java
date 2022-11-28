package Beijing;
/*
https://leetcode.cn/problems/largest-sum-of-averages/
 */

/**
 * @author zhouhao
 * @date 2022/11/28 21:19
 */

public class LargestSumOfAverages {
    // 自己不会写
    static class Solution {
        public double largestSumOfAverages(int[] nums, int k) {
            double[] sum = new double[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
            double[][] dp = new double[nums.length + 1][k + 1];
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= Math.min(i, k); j++) {
                    if (j == 1) {
                        dp[i][j] = sum[i] / i;
                    } else {
                        for (int l = 2; l <= i; l++) {
                            dp[i][j] = Math.max(dp[i][j], dp[l - 1][j - 1] + (sum[i] - sum[l - 1]) / (i - l + 1));
                        }
                    }
                }
            }
            return dp[nums.length][k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, 1, 2, 3, 9};
        int k = 3;
        System.out.println(new Solution().largestSumOfAverages(nums, k));
    }
}
