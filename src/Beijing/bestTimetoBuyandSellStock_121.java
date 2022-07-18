package Beijing;
/*
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */

public class bestTimetoBuyandSellStock_121 {
    // 第二次了，还是不会写
    static class Solution {
        public int maxProfit(int[] prices) {
            int ans = 0;
            int minPrice = prices[0];
            for (int price : prices) {
                if (price < minPrice) {
                    minPrice = price;
                } else {
                    ans = Math.max(ans, price - minPrice);
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
