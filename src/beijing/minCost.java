package beijing;
/*
https://leetcode.cn/problems/JEj789/
 */

// 很典型的dp
public class minCost {
    static class Solution {
        public int minCost(int[][] costs) {
            /*
            dp[i][j]=min(costs[i-1][(j+1)%3],costs[i-1][(j+2)%3])
             */
            int[][] dp = new int[costs.length][3];
            dp[0] = costs[0];
            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + costs[i][j];
                }
            }
            return Math.min(dp[costs.length - 1][0], Math.min(dp[costs.length - 1][1], dp[costs.length - 1][2]));
        }
    }

    public static void main(String[] args) {
        int[][] costs = {
                {17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}
        };
        System.out.println(new Solution().minCost(costs));
    }
}
