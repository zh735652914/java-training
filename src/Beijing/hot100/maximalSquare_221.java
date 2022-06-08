package Beijing.hot100;
/*
https://leetcode.cn/problems/maximal-square/
 */

public class maximalSquare_221 {
    // 第二次写还是不会，得多思考思考
    static class Solution {
        public int maximalSquare(char[][] matrix) {
            int[][] dp = new int[matrix.length][matrix[0].length];
            int ans = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        }
                    }
                    ans = Math.max(ans, dp[i][j]);
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
