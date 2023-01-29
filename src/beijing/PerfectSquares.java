package beijing;
/*
https://leetcode-cn.com/problems/perfect-squares/
 */

public class PerfectSquares {
    // 这个dp我没想到
    static class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 1; i <= n; i++) {
                int minNum = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    minNum = Math.min(minNum, dp[i - j * j]);
                }
                dp[i] = 1 + minNum;
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(new Solution().numSquares(n));
    }
}
