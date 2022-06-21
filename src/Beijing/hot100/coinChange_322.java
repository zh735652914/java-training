package Beijing.hot100;
/*
https://leetcode.cn/problems/coin-change/
 */

import java.util.Arrays;

// 这个dp还是挺有意思的
public class coinChange_322 {
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int coin : coins) {
                if (coin <= amount) {
                    dp[coin] = 1;
                }
            }
            for (int i = 1; i <= amount; i++) {
                int min = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (coin <= i && dp[i - coin] != -1) {
                        min = Math.min(min, dp[i - coin] + dp[coin]);
                    }
                }
                dp[i] = min == Integer.MAX_VALUE ? -1 : min;
            }
            return dp[amount];
        }
    }

    public static void main(String[] args) {
        int[] coins = {1};
        int amount = 0;
        System.out.println(new Solution().coinChange(coins, amount));
    }
}
