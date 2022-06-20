package Beijing.hot100;
/*
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */

// 第二次写，自己还是不会
public class bestTimetoBuyandSellStockwithCooldown_309 {
    static class Solution {
        public int maxProfit(int[] prices) {
            /*
            dp[i][0]=dp[i-1][2]-prices[i],dp[i-1][0]
            dp[i][1]=dp[i-1][0]+prices[i]
            dp[i][2]=dp[i-1][1],dp[i-1][2]
             */
            int[][] dp = new int[prices.length][3];
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            dp[0][2] = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][0]);
                dp[i][1] = dp[i - 1][0] + prices[i];
                dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            }
            return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
        }
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(new Solution().maxProfit(prices));
    }
}
