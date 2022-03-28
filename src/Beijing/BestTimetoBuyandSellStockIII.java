package Beijing;
/*
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 */

// 这个是官方的解析，有点意思，需要好好看看
public class BestTimetoBuyandSellStockIII {
    static class Solution {
        public int maxProfit(int[] prices) {
            int buy1 = -prices[0];
            int sell1 = 0;
            int buy2 = -prices[0];
            int sell2 = 0;
            for (int i = 1; i < prices.length; i++) {
                buy1 = Math.max(buy1, -prices[i]);
                sell1 = Math.max(sell1, buy1 + prices[i]);
                buy2 = Math.max(buy2, sell1 - prices[i]);
                sell2 = Math.max(sell2, buy2 + prices[i]);
            }
            return sell2;
        }
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
