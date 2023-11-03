package beijing;
/*
https://leetcode-cn.com/problems/interleaving-string/
 */

public class InterleavingString {
    // 自己没写出来，其中第几个，前几个，这个要分清楚
    static class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            if (s1.length() < 1 && s2.length() < 1 && s3.length() < 1) {
                return true;
            }
            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
            dp[0][0] = true;
            for (int i = 0; i <= s1.length(); i++) {
                for (int j = 0; j <= s2.length(); j++) {
                    int pos = i + j - 1;
                    if (i > 0) {
                        dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(pos));
                    }
                    if (j > 0) {
                        dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(pos));
                    }
                }
            }
            return dp[s1.length()][s2.length()];
        }
    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(new Solution().isInterleave(s1, s2, s3));
    }
}
