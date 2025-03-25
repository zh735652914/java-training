package next;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/3/25 08:22
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
 */
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - minPrice);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertEquals(5, maxProfit(prices));
    }
}
