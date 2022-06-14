package Beijing.hot100;
/*
https://leetcode.cn/problems/perfect-squares/
 */

public class perfectSquares_279 {
    // 第二次写还是不会，这个dp很重要！
    static class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    min = Math.min(min, dp[i - j * j]);
                }
                dp[i] = min + 1;
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(new Solution().numSquares(n));
    }
}
