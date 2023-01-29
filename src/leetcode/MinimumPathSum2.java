package leetcode;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
class MinimumPathSum2Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int x = 1; x < grid.length; x++) {
            for (int y = 1; y < grid[0].length; y++) {
                dp[x][y] = Math.min(dp[x - 1][y], dp[x][y - 1]) + grid[x][y];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}

public class MinimumPathSum2 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        MinimumPathSum2Solution minimumPathSum2Solution = new MinimumPathSum2Solution();
        System.out.println(minimumPathSum2Solution.minPathSum(grid));
    }
}
