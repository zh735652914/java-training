package leetcode;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
 */
//不是自己写的。。。
class LongestIncreasingSubsequenceSolution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length < 1) return 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {4, 10, 4, 3, 8, 9};//3
        LongestIncreasingSubsequenceSolution longestIncreasingSubsequenceSolution = new LongestIncreasingSubsequenceSolution();
        System.out.println(longestIncreasingSubsequenceSolution.lengthOfLIS(nums));
    }
}
