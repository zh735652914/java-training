package beijing;
/*
https://leetcode.cn/problems/house-robber/?envType=daily-question&envId=2023-09-16
 */

/**
 * @author zhouhao
 * @date 2023/9/16 09:43
 */
public class HouseRobber_198 {
    // 典型dp
    static class Solution {
        public int rob(int[] nums) {
            /*
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i])
             */
            if (nums.length < 2) {
                return nums.length == 1 ? nums[0] : 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[nums.length - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution().rob(nums));
    }
}
