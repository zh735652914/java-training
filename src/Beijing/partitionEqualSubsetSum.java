package Beijing;
/*
https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */

public class partitionEqualSubsetSum {
    // 这题看了答案才写出来，用dp我是没想到的
    static class Solution {
        public boolean canPartition(int[] nums) {
            int target = 0, max = 0;
            for (int num : nums) {
                target += num;
                max = Math.max(max, num);
            }
            if ((target & 1) == 1) {
                return false;
            }
            target /= 2;
            if (max > target) {
                return false;
            }
            /*
            dp[i][j] 数组下标0到i中是否有子数组和为j;
            dp[i][j]=dp[i-1][j]     j<nums[i]
            dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]]     j>=nums[i]
             */
            boolean[][] dp = new boolean[nums.length][target + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = false;
            }
            dp[0][nums[0]] = true;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 1; j <= target; j++) {
                    if (j >= nums[i]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[nums.length - 1][target];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(new Solution().canPartition(nums));
    }
}
