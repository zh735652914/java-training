package beijing;
/*
https://leetcode.cn/problems/house-robber/
 */

public class HouseRobber_198_topInterviewList {
    // 程序化的dp
    static class Solution {
        public int rob(int[] nums) {
            /*
            dp[i][0]=max(dp[i-1][1],dp[i-1][0])
            dp[i][1]=dp[i-1][0]+nums[i]
             */
            int[][] dp = new int[nums.length][2];
            dp[0][1] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
                dp[i][1] = dp[i - 1][0] + nums[i];
            }
            return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution().rob(nums));
    }
}
