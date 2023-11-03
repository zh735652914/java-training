package beijing;

public class BestTimetoBuyandSellStock {
    // 官方解答更好
    static class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int ans = 0;
            for (int i = 0; i < prices.length; i++) {
                if (minPrice > prices[i]) {
                    minPrice = prices[i];
                } else if (prices[i] - minPrice > ans) {
                    ans = prices[i] - minPrice;
                }
            }
            return ans;
        }
    }

    // 自己写的效率不高
    static class Solution0 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[] min = new int[n];
            int[] max = new int[n];
            min[0] = prices[0];
            max[n - 1] = prices[n - 1];
            for (int i = 1; i < n; i++) {
                min[i] = Math.min(min[i - 1], prices[i]);
                max[n - i - 1] = Math.max(max[n - i], prices[n - i - 1]);
            }
            int ans = max[0] - min[0];
            for (int i = 1; i < n; i++) {
                ans = Math.max(ans, max[i] - min[i]);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
