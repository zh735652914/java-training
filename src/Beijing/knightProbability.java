package Beijing;
/*
https://leetcode-cn.com/problems/knight-probability-in-chessboard/
 */

public class knightProbability {
    static class Solution {
        public double knightProbability(int n, int k, int row, int column) {
            int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
            double[][][] dp = new double[k + 1][n][n];
            for (int i = 0; i <= k; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        if (i == 0) {
                            dp[i][j][l] = 1;
                        } else {
                            for (int[] dir : dirs) {
                                int lastj = j + dir[0], lastl = l + dir[1];
                                if (lastj >= 0 && lastj < n && lastl >= 0 && lastl < n) {
                                    dp[i][j][l] += dp[i - 1][lastj][lastl] / 8;
                                }
                            }
                        }
                    }
                }
            }
            return dp[k][row][column];
        }
    }

    public static void main(String[] args) {
        int n = 3, k = 2, row = 0, column = 0;
        System.out.println(new Solution().knightProbability(n, k, row, column));
    }
}
