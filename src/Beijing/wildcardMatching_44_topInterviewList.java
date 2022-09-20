package Beijing;
/*
https://leetcode.cn/problems/wildcard-matching/
 */

// 自己没写出来
public class wildcardMatching_44_topInterviewList {
    static class Solution {
        public boolean isMatch(String s, String p) {
            /*
            dp[i][j] s的前i位和p的前j位能否配对
            dp[i][j]=dp[i-1][j-1]&&p[j]==s[i]   p[j-1]!='?'&&p[j-1]!='*'
            dp[i][j]=dp[i-1][j-1]               p[j-1]='?'
            dp[i][j]=dp[i-1][j]||dp[i][j-1]     p[j-1]='*'
             */
            int lenS = s.length(), lenP = p.length();
            boolean[][] dp = new boolean[lenS + 1][lenP + 1];
            dp[0][0] = true;
            for (int i = 0; i < lenP; i++) {
                if (p.charAt(i) == '*') {
                    dp[0][i + 1] = true;
                } else {
                    break;
                }
            }
            for (int i = 1; i <= lenS; i++) {
                for (int j = 1; j <= lenP; j++) {
                    if (p.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] && p.charAt(j - 1) == s.charAt(i - 1);
                    }
                }
            }
            return dp[lenS][lenP];
        }
    }

    public static void main(String[] args) {
        String s = "aa", p = "a";
        System.out.println(new Solution().isMatch(s, p));
    }
}
