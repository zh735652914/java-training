package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/17 08:48
 * https://leetcode.cn/problems/unique-paths/description/
 */
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        /**
         * dp[i][j]=dp[i-1][j]+dp[i][j-1]
         */
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void test() {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m, n));
    }
}
