package Beijing;
/*
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

public class BestTimetoBuyAndSellStockII {
    // 官方的贪心算法
    static class Solution {
        public int maxProfit(int[] prices) {
            int ans = 0;
            for (int i = 1; i < prices.length; i++) {
                ans += Math.max(0, prices[i] - prices[i - 1]);
            }
            return ans;
        }
    }

    // 这个方法，我他妈都不会写了，真完犊子
    static class Solution0 {
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                /*
                dp[i][0]=max(dp[i-1][0],dp[i-1][1]+price[i])
                dp[i][1]=max(dp[i-1][0]-price[i],dp[i-1][1])
                 */
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            }
            return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
        }
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
