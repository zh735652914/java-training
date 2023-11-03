package beijing;
/*
https://leetcode.cn/problems/coin-change/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2022/12/27 21:08
 */
public class CoinChange_322_topInterviewList {
    // 自己还是不会写，但是有点印象
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (coin <= i) {
                        if (dp[i - coin] == -1) {
                            continue;
                        }
                        if (dp[i] == -1) {
                            dp[i] = dp[i - coin] + 1;
                        } else {
                            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                        }
                    }
                }
            }
            return dp[amount];
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new Solution().coinChange(coins, amount));
    }
}
