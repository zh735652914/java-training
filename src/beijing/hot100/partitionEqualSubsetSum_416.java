package beijing.hot100;
/*
https://leetcode.cn/problems/partition-equal-subset-sum/
 */

public class partitionEqualSubsetSum_416 {
    // 第二次写，自己还是不会，很重要！
    static class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            int maxNum = Integer.MIN_VALUE;
            for (int num : nums) {
                sum += num;
                maxNum = Math.max(maxNum, num);
            }
            int target = sum >> 1;
            if ((sum & 1) == 1 || maxNum > target) {
                return false;
            }
            /*
            dp[i][j]=dp[i-1][j]     num[i]>j
            dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]]
             */
            boolean[][] dp = new boolean[nums.length][target + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = false;
            }
            dp[0][nums[0]] = true;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 1; j <= target; j++) {
                    if (nums[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
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
