package Beijing.hot100;
/*
https://leetcode.cn/problems/climbing-stairs/
 */

public class climbingStairs_70 {
    // 很简单的dp，只不过要用滚动数组
    static class Solution {
        public int climbStairs(int n) {
            if (n < 3) {
                return n;
            }
            /*
            dp[i]=dp[i-1]+dp[i-2]
             */
            int lastOne = 2, lastTwo = 1;
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
        int n = 4;
        System.out.println(new Solution().climbStairs(n));
    }
}
