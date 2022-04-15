package Beijing;
/*
https://leetcode-cn.com/problems/house-robber/
 */

public class HouseRobber {
    // 典型的dp
    static class Solution {
        public int rob(int[] nums) {
            /*
            dp[i]=max(dp[i-1],dp[i-2]+nums[i])
             */
            if (nums.length < 2) {
                return nums.length == 1 ? nums[0] : 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[1], dp[0]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[nums.length - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new Solution().rob(nums));
    }
}
