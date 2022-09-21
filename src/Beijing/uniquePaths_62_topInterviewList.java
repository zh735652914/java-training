package Beijing;
/*
https://leetcode.cn/problems/unique-paths/
 */

import java.util.Arrays;

public class uniquePaths_62_topInterviewList {

    // 大佬们的答案，很厉害
    static class Solution {
        public int uniquePaths(int m, int n) {
            int[] cur = new int[n];
            Arrays.fill(cur, 1);
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    cur[j] += cur[j - 1];
                }
            }
            return cur[n - 1];
        }
    }

    // 需要看解析中简化版本的代码
    static class Solution0 {
        public int uniquePaths(int m, int n) {
            /*
            dp[i][j]=dp[i-1][j]+dp[i][j-1]
             */
            int[][] dp = new int[m][n];
            Arrays.fill(dp[0], 1);
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(new Solution().uniquePaths(m, n));
    }
}
