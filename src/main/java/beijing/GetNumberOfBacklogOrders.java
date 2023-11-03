package beijing;
/*
https://leetcode.cn/problems/number-of-orders-in-the-backlog/
 */

import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhouhao
 * @date 2023/1/2 15:08
 */
public class GetNumberOfBacklogOrders {
    // 好吧其实真的不难
    static class Solution {
        public int getNumberOfBacklogOrders(int[][] orders) {
            final int MOD = 1000000007;
            TreeMap<Integer, Integer> sell = new TreeMap<>();
            TreeMap<Integer, Integer> buy = new TreeMap<>();
            for (int[] order : orders) {
                if (order[2] == 0) {
                    while (!sell.isEmpty() && order[0] >= sell.firstKey() && order[1] > 0) {
                        int count = sell.get(sell.firstKey());
                        int sellAmount = Math.min(count, order[1]);
                        count -= sellAmount;
                        order[1] -= sellAmount;
                        if (count <= 0) {
                            sell.remove(sell.firstKey());
                        } else {
                            sell.put(sell.firstKey(), count);
                        }
                    }
                    if (order[1] > 0) {
                        buy.put(order[0], buy.getOrDefault(order[0], 0) + order[1]);
                    }
                } else {
                    while (!buy.isEmpty() && order[0] <= buy.lastKey() && order[1] > 0) {
                        int count = buy.get(buy.lastKey());
                        int buyAmount = Math.min(count, order[1]);
                        count -= buyAmount;
                        order[1] -= buyAmount;
                        if (count <= 0) {
                            buy.remove(buy.lastKey());
                        } else {
                            buy.put(buy.lastKey(), count);
                        }
                    }
                    if (order[1] > 0) {
                        sell.put(order[0], sell.getOrDefault(order[0], 0) + order[1]);
                    }
                }
            }
            long ans = 0;
            for (Map.Entry<Integer, Integer> entry : buy.entrySet()) {
                ans = ans + entry.getValue();
            }
            for (Map.Entry<Integer, Integer> entry : sell.entrySet()) {
                ans = ans + entry.getValue();
            }
            return (int) (ans % MOD);
        }
    }

    public static void main(String[] args) {
        int[][] orders = {{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}};
        System.out.println(new Solution().getNumberOfBacklogOrders(orders));
    }
}
