package beijing;
/*
https://leetcode-cn.com/problems/unique-paths-ii/
 */

public class UniquePathsII {
    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
            dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
            for (int i = 1; i < obstacleGrid.length; i++) {
                dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
            }
            for (int i = 1; i < obstacleGrid[0].length; i++) {
                dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i - 1];
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        }
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
//        int[][] obstacleGrid = {
//                {1, 0}
//        };
        System.out.println(new Solution().uniquePathsWithObstacles(obstacleGrid));
    }
}
