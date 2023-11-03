package beijing;
/*
https://leetcode.cn/problems/perfect-squares/
 */

public class PerfectSquares_279_topInterviewList {
    // 第三次了，还是不会写
    static class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 1; i <= n; i++) {
                int minCount = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    minCount = Math.min(minCount, dp[i - j * j]);
                }
                dp[i] = minCount + 1;
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(new Solution().numSquares(n));
    }
}
