package beijing;
/*
https://leetcode-cn.com/problems/maximal-square/
 */

public class maximalSquare {
    static class Solution {
        public int maximalSquare(char[][] matrix) {
            /*
            dp[i][j]=0 (matrix[i][j]==0)
            dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
             */
            int[][] dp = new int[matrix.length][matrix[0].length];
            dp[0][0] = matrix[0][0] == '1' ? 1 : 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int ans = dp[0][0];
            for (int i = 1; i < m; i++) {
                dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
                ans = Math.max(ans, dp[i][0]);
            }
            for (int i = 1; i < n; i++) {
                dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
                ans = Math.max(ans, dp[0][i]);
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
            return ans * ans;
        }
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(new Solution().maximalSquare(matrix));
    }
}
