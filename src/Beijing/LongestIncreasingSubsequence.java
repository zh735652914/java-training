package Beijing;
/*
https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */

// 两个方法都不会，得好好看看，特别是这个二分法
public class LongestIncreasingSubsequence {
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] d = new int[n];
            d[0] = nums[0];
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] > d[count - 1]) {
                    d[count] = nums[i];
                    count++;
                } else {
                    int left = 0, right = count, pos = -1;
                    while (left <= right) {
                        int mid = (left + right) / 2;
                        if (d[mid] < nums[i]) {
                            left = mid + 1;
                            pos = mid;
                        } else {
                            right = mid - 1;
                        }
                    }
                    d[pos + 1] = nums[i];
                }
            }
            return count;
        }
    }

    static class Solution0 {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int ans = 1;
            for (int i = 1; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
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
