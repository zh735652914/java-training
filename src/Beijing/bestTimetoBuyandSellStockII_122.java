package Beijing;
/*
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 */

public class bestTimetoBuyandSellStockII_122 {
    // 官方的解法，自己还是没想到
    static class Solution {
        public int maxProfit(int[] prices) {
            int ans = 0;
            for (int i = 1; i < prices.length; i++) {
                ans += Math.max(0, prices[i] - prices[i - 1]);
            }
            return ans;
        }
    }

    // 自己写的dp效率不太高
    static class Solution0 {
        public int maxProfit(int[] prices) {
            /*
            dp[i][1]=max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][0]=max(dp[i-1][0],dp[i-1][1]+prices[i]);
             */
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            }
//            System.out.println(dp[prices.length - 1][0]);
//            return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][0]);
            return dp[prices.length - 1][0];
        }
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
