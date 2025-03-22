package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/22 10:25
 */
public class LeetCode96 {
    public int numTrees(int n) {
        /*
        dp[i]为i个节点可以组成多少个不同的搜索二叉树
         */
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        int n = 3;
        System.out.println(numTrees(n));
    }
}
