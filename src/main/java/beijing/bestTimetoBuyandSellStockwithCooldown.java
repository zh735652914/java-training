package beijing;

public class bestTimetoBuyandSellStockwithCooldown {
    // dp的转移情况得想清楚
    static class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][3];
            /*
            dp[i][0] 买入；
            dp[i][1] 卖出；
            dp[i][2] 冷冻
             */
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            dp[0][2] = 0;
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][0]);
                dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
            }
            return Math.max(dp[n - 1][1], dp[n - 1][2]);
        }
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(new Solution().maxProfit(prices));
    }
}
