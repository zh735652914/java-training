package beijing;
/*
https://leetcode.cn/problems/longest-arithmetic-subsequence/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/4/22 15:37
 */
public class LongestArithSeqLength {
    // 这个dp有点难度
    static class Solution {
        public int longestArithSeqLength(int[] nums) {
            /*
            dp[nums[i]]=1;
            dp[nums[i]]=dp[nums[i]-d]+1; dp[nums[i]-d]!=-1;
             */
            int max = Arrays.stream(nums).max().getAsInt();
            int min = Arrays.stream(nums).min().getAsInt();
            int diff = max - min;
            int[] dp = new int[max + 1];
            int ans = 1;
            for (int d = -diff; d <= diff; d++) {
                Arrays.fill(dp, -1);
                for (int num : nums) {
                    if ((num - d) >= 0 && (num - d) < dp.length && dp[num - d] != -1) {
                        dp[num] = Math.max(dp[num], dp[num - d] + 1);
                    } else {
                        dp[num] = 1;
                    }
                    ans = Math.max(ans, dp[num]);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 12};
        System.out.println(new Solution().longestArithSeqLength(nums));
    }
}
