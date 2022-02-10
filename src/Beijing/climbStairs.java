package Beijing;
/*
https://leetcode-cn.com/problems/climbing-stairs/
 */

public class climbStairs {
    // 别人写的更简洁
    static class Solution {
        public int climbStairs(int n) {
            if (n < 3) {
                return n;
            }
            int a = 1, b = 2, tmp;
            for (int i = 3; i <= n; i++) {
                tmp = a;
                a = b;
                b = a + tmp;
            }
            return b;
        }
    }

    static class Solution0 {
        public int climbStairs(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i < n + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().climbStairs(n));
    }
}
