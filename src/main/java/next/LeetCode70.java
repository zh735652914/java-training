package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/19 08:24
 * https://leetcode.cn/problems/climbing-stairs/
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        /*
        dp[i]=dp[i-1]+dp[i-2]
         */
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    @Test
    public void test() {
        int n = 3;
        System.out.println(climbStairs(n));
    }
}
