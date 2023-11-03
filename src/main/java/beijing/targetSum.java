package beijing;
/*
https://leetcode-cn.com/problems/target-sum/
 */

// 不是自己写的，但是这个dp很重要！！
public class targetSum {
    static class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            sum += target;
            if (sum < 0 || (sum & 1) == 1) {
                return 0;
            }
            int T = sum / 2;
            int[][] dp = new int[nums.length + 1][T + 1]; // dp[i][j]前i个数字中子数组和为j的数量
            /*
            dp[i][j]=dp[i-1][j]     nums[i]>j
            dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i]]      nums[i]<=j
             */
            dp[0][0] = 1;
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 0; j <= T; j++) {
                    if (j < nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[nums.length][T];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(new Solution().findTargetSumWays(nums, target));
    }
}
