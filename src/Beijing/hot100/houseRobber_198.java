package Beijing.hot100;
/*
https://leetcode.cn/problems/house-robber/
 */

public class houseRobber_198 {
    // 典型的dp，只是要注意特殊测试用例
    static class Solution {
        public int rob(int[] nums) {
            /*
            dp[i]=max(dp[i-2]+nums[i],dp[i-1]);
            dp[0]=nums[0];
            dp[1]=max(nums[0],nums[1]);
             */
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[nums.length - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution().rob(nums));
    }
}
