package Beijing;
/*
https://leetcode-cn.com/problems/ugly-number-ii/
 */

public class UglyNumberII {
    // 这题需要看看！！！！！
    static class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            int x = 0, y = 0, z = 0;
            for (int i = 1; i < n; i++) {
                int A = dp[x] * 2, B = dp[y] * 3, C = dp[z] * 5;
                dp[i] = Math.min(A, Math.min(B, C));
                if (dp[i] == A) {
                    x++;
                }
                if (dp[i] == B) {
                    y++;
                }
                if (dp[i] == C) {
                    z++;
                }
            }
            return dp[n - 1];
        }
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution().nthUglyNumber(n));
    }
}
