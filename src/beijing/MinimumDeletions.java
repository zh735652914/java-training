package beijing;
/*
https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
 */

/**
 * @author zhouhao
 * @date 2023/3/6 12:54
 */
public class MinimumDeletions {
    // 这个动态规划自己没想到
    static class Solution {
        public int minimumDeletions(String s) {
            /*
            x==b dp[i]=dp[i-1],cntB++;
            x==a dp[i]=min(dp[i-1]+1,cntB);
             */
            int dp = 0, cntB = 0;
            for (int x : s.toCharArray()) {
                if (x == 'b') {
                    cntB++;
                } else {
                    dp = Math.min(dp + 1, cntB);
                }
            }
            return dp;
        }
    }

    public static void main(String[] args) {
        String s = "aababbab";
        System.out.println(new Solution().minimumDeletions(s));
    }
}
