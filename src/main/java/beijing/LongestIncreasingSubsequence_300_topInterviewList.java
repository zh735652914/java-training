package beijing;
/*
https://leetcode.cn/problems/longest-increasing-subsequence/
 */

/**
 * @author zhouhao
 * @date 2022/12/27 13:27
 */
public class LongestIncreasingSubsequence_300_topInterviewList {
    // 自己还是不会写
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            /*
            dp[i]=1
            dp[i]=max(dp[n])+1
             */
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int ans = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                ans = Math.max(dp[i], ans);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}
