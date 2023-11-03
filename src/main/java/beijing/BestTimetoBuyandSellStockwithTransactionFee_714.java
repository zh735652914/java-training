package beijing;
/*
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/?envType=daily-question&envId=2023-10-06
 */

/**
 * @author zhouhao
 * @date 2023/10/6 10:42
 */
public class BestTimetoBuyandSellStockwithTransactionFee_714 {
    // 这题不难
    static class Solution {
        public int maxProfit(int[] prices, int fee) {
            /*
            dp[i][0]=max(dp[i-1][1]-prices[i],dp[i-1][0])
            dp[i][1]=max(dp[i-1][0]+prices[i]-fee,dp[i-1][1])
             */
            int[][] dp = new int[prices.length][2];
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
                dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
            }
            return dp[prices.length - 1][1];
        }
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(new Solution().maxProfit(prices, fee));
    }
}
