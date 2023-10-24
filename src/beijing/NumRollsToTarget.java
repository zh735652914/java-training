package beijing;

/**
 * @author zhouhao
 * @date 2023/10/24 12:43
 */
public class NumRollsToTarget {
    // 自己不会写
    static class Solution {
        private static final int MOD = 1000000007;

        public int numRollsToTarget(int n, int k, int target) {
            /*
            dp[i][j]=sum(dp[i-1][j-x])
             */
            int[][] dp = new int[n + 1][target + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= target; j++) {
                    for (int x = 1; x <= k; x++) {
                        if (j - x >= 0) {
                            dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % MOD;
                        }
                    }
                }
            }
            return dp[n][target];
        }
    }

    public static void main(String[] args) {
        int n = 2, k = 6, target = 7;
        System.out.println(new Solution().numRollsToTarget(n, k, target));
    }
}
