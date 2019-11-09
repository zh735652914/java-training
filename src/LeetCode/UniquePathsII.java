package LeetCode;
/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?



An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
 */

class UniquePathsIISolution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                break;
            }
            dp[0][i] = 1;
        }
        for (int x = 1; x < obstacleGrid.length; x++) {
            for (int y = 1; y < obstacleGrid[0].length; y++) {
                if (obstacleGrid[x][y] == 1) {
                    dp[x][y] = 0;
                } else {
                    dp[x][y] = dp[x - 1][y] + dp[x][y - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}

public class UniquePathsII {
    public static void main(String[] args) {
//        int[][] obstacleGrid = {
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 1}
//        };
        int[][] obstacleGrid = {{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};// 7
        UniquePathsIISolution uniquePathsIISolution = new UniquePathsIISolution();
        System.out.println(uniquePathsIISolution.uniquePathsWithObstacles(obstacleGrid));
    }
}
