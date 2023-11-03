package beijing;
/*
https://leetcode.cn/problems/minimum-falling-path-sum/
 */

/**
 * @author zhouhao
 * @date 2023/7/13 12:28
 */
public class MinFallingPathSum {
    static class Solution {
        // 很典型的dp
        public int minFallingPathSum(int[][] matrix) {
            /*
            dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i-1][j+1])+matrix[i][j]
             */
            int[][] dp = new int[matrix.length][matrix[0].length];
            dp[0] = matrix[0];
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int min = dp[i - 1][j];
                    if (j - 1 >= 0) {
                        min = Math.min(min, dp[i - 1][j - 1]);
                    }
                    if (j + 1 < matrix[0].length) {
                        min = Math.min(min, dp[i - 1][j + 1]);
                    }
                    dp[i][j] = matrix[i][j] + min;
                }
            }
            int ans = dp[matrix.length - 1][0];
            for (int x : dp[matrix.length - 1]) {
                ans = Math.min(ans, x);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(new Solution().minFallingPathSum(matrix));
    }
}
