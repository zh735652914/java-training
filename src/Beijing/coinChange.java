package Beijing;
/*
https://leetcode-cn.com/problems/coin-change/
 */

import java.util.Arrays;

public class coinChange {
    // 不是自己写的
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int i = 1; i < amount + 1; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        if (dp[i - coins[j]] == -1) {
                            continue;
                        }
                        if (dp[i] == -1) {
                            dp[i] = dp[i - coins[j]] + 1;
                            continue;
                        }
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount];
        }
    }

    // 超时了
    static class Solution0 {
        private int ans;

        public int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);
            int n = coins.length;
            ans = Integer.MAX_VALUE;
            dfs(coins, amount, n - 1, 0);
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }

        private void dfs(int[] coins, int amount, int index, int count) {
            if (amount == 0) {
                ans = Math.min(ans, count);
                return;
            }
            if (index < 0) {
                return;
            }
            if (coins[index] <= amount) {
                dfs(coins, amount - coins[index], index, count + 1);
                dfs(coins, amount, index - 1, count);
            } else {
                while (--index >= 0) {
                    dfs(coins, amount, index, count);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
//        int[] coins = {1, 2, 5};
//        int amount = 11;
        System.out.println(new Solution().coinChange(coins, amount));
    }
}
