package LeetCode;
/*
Share
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie,
 buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */

class BestTimetoBuyandSellStockwithCooldownSolution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] profit = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            profit[i] = prices[i + 1] - prices[i];
        }
        int[] dp = new int[profit.length];
        int[] ans = new int[profit.length];
        for (int i = 0; i < profit.length; i++) {
            if (i - 3 >= 0) {
                dp[i] = Math.max(Math.max(dp[i - 1] + profit[i], ans[i - 3] + profit[i]), profit[i]);
            } else if (i - 1 >= 0) {
                dp[i] = Math.max(dp[i - 1] + profit[i], profit[i]);
            } else {
                dp[i] = profit[i];
            }
            ans[i] = i > 0 ? Math.max(ans[i - 1], dp[i]) : Math.max(ans[i], dp[i]);
        }
        return ans[ans.length - 1];
    }
}

public class BestTimetoBuyandSellStockwithCooldown {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 0, 2}; //3
//        int[] nums = {1, 2, 3, 0, 2, 5, 6, 2}; //7
//        int[] nums = {4, 2, 7, 1, 11}; //10
        int[] nums = {6, 1, 6, 4, 3, 0, 2}; //7
        BestTimetoBuyandSellStockwithCooldownSolution bestTimetoBuyandSellStockwithCooldownSolution = new BestTimetoBuyandSellStockwithCooldownSolution();
        System.out.println(bestTimetoBuyandSellStockwithCooldownSolution.maxProfit(nums));
    }
}
