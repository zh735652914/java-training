package Beijing;
/*
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */

public class bestTimetoBuyandSellStock_121_topInterviewList {
    // 第三次了，还是自己没想到
    static class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = prices[0];
            int ans = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                } else {
                    ans = Math.max(ans, prices[i] - minPrice);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
