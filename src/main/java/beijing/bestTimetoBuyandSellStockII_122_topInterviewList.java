package beijing;
/*
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 */

// 很多次了，自己还是不会写
public class bestTimetoBuyandSellStockII_122_topInterviewList {
    static class Solution {
        public int maxProfit(int[] prices) {
            int ans = 0;
            for (int i = 1; i < prices.length; i++) {
                ans += Math.max(0, prices[i] - prices[i - 1]);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
