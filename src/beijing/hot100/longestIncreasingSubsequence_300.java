package beijing.hot100;
/*
https://leetcode.cn/problems/longest-increasing-subsequence/
 */

public class longestIncreasingSubsequence_300 {

    // 这个二分第二次还是没想到
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length + 1];
            dp[1] = nums[0];
            int len = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > dp[len]) {
                    dp[++len] = nums[i];
                } else {
                    int left = 1, right = len, pos = 0;
                    while (left <= right) {
                        int mid = left + (right - len) / 2;
                        if (dp[mid] < nums[i]) {
                            pos = mid;
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                    dp[pos + 1] = nums[i];
                }
            }
            return len;
        }
    }

    // 这个O(n^2)的算法，我一开始给放弃了
    static class Solution0 {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int ans = 1;
            for (int i = 1; i < nums.length; i++) {
                int max = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        max = Math.max(max, dp[j]);
                    }
                }
                dp[i] = max + 1;
                ans = Math.max(ans, dp[i]);
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}
