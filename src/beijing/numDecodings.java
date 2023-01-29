package beijing;
/*
https://leetcode-cn.com/problems/decode-ways/
 */

// dp，然后很多情况要注意一下
public class numDecodings {
    static class Solution {
        public int numDecodings(String s) {
            /*
            dp[i]=dp[i-1]+{dp[i-2]}
             */
            if (s.length() < 2) {
                if (s.length() == 1) {
                    return s.charAt(0) != '0' ? 1 : 0;
                }
                return 0;
            }
            int[] dp = new int[s.length()];
            dp[0] = isChar(s.charAt(0)) ? 1 : 0;
            dp[1] = isLetter(s, 1) ? 1 : 0;
            dp[1] += isChar(s.charAt(1)) ? dp[0] : 0;
            for (int i = 2; i < s.length(); i++) {
                dp[i] = isChar(s.charAt(i)) ? dp[i - 1] : 0;
                dp[i] += isLetter(s, i) ? dp[i - 2] : 0;
            }
            return dp[s.length() - 1];
        }

        private boolean isChar(char x) {
            return x != '0';
        }

        private boolean isLetter(String s, int index) {
            return index > 0 && s.charAt(index - 1) != '0' && Integer.parseInt(s.substring(index - 1, index + 1)) <= 26;
        }
    }

    public static void main(String[] args) {
        String s = "226";
        System.out.println(new Solution().numDecodings(s));
    }
}
