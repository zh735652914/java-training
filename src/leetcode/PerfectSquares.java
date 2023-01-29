package leetcode;
/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */
//不会写，根本没思路。。。

import java.util.Arrays;

class PerfectSquaresSolution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
            }
        }
        return dp[n];
    }
}

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 12;
        PerfectSquaresSolution perfectSquaresSolution = new PerfectSquaresSolution();
        System.out.println(perfectSquaresSolution.numSquares(n));
    }
}
