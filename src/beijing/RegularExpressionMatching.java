package beijing;
/*
https://leetcode-cn.com/problems/regular-expression-matching/
 */

public class RegularExpressionMatching {
    static class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
            f[0][0] = true;
            for (int i = 0; i < s.length() + 1; i++) {
                for (int j = 1; j < p.length() + 1; j++) {
                    if (p.charAt(j - 1) == '*') {
                        f[i][j] = f[i][j - 2];
                        if (matches(s, p, i, j - 1)) {
                            f[i][j] = f[i][j] || f[i - 1][j];
                        }
                    } else {
                        if (matches(s, p, i, j)) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }
                }
            }
            return f[s.length()][p.length()];
        }

        private boolean matches(String s, String p, int i, int j) {
            if (i == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
    }

    public static void main(String[] args) {
        String s = "aab", p = "c*a*b";
        System.out.println(new Solution().isMatch(s, p));
    }
}
