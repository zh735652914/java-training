package Beijing;
/*
https://leetcode.cn/problems/decode-ways/
 */

public class decodeWays_91_topInterviewList {
    static class Solution {
        // dp的情况要写对
        public int numDecodings(String s) {
            /*
            dp[i]=dp[i-1]+dp[i-2]   s(i-1,i),s(i-2,i)
            dp[i]=dp[i-1] s(i-1,i)
            dp[i]=0
             */
            int len = s.length();
            int[] dp = new int[len + 1];
            if (check(s.substring(0, 1))) {
                dp[1] = 1;
            }
            if (len < 2) {
                return dp[1];
            }
            if (check(s.substring(0, 2))) {
                dp[2] = check(s.substring(1, 2)) ? dp[1] + 1 : 1;
            } else {
                dp[2] = check(s.substring(1, 2)) ? dp[1] : 0;
            }
            for (int i = 3; i <= len; i++) {
                if (check(s.substring(i - 2, i))) {
                    dp[i] = check(s.substring(i - 1, i)) ? dp[i - 1] + dp[i - 2] : dp[i - 2];
                } else {
                    dp[i] = check(s.substring(i - 1, i)) ? dp[i - 1] : 0;
                }
            }
            return dp[len];
        }

        private boolean check(String s) {
            if (s.charAt(0) == '0') {
                return false;
            }
            int num = Integer.parseInt(s);
            return num >= 1 && num <= 26;
        }
    }

    public static void main(String[] args) {
        String s = "2611055971756562";
        System.out.println(new Solution().numDecodings(s));
    }
}
