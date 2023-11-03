package beijing;
/*
https://leetcode.cn/problems/climbing-stairs/
 */

public class climbingStairs_70 {
    static class Solution {
        public int climbStairs(int n) {
            if (n < 3) {
                return n;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    // 滚动数组的写法需要看看
    static class Solution1 {
        public int climbStairs(int n) {
            if (n < 3) {
                return n;
            }
            int lastOne = 2;
            int lastTwo = 1;
            /*
            dp[i]=dp[i-1]+dp[i-2]
             */
            int cur = 0;
            for (int i = 3; i <= n; i++) {
                cur = lastOne + lastTwo;
                lastTwo = lastOne;
                lastOne = cur;
            }
            return cur;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().climbStairs(n));
    }
}
