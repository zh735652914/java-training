package beijing;
/*
https://leetcode.cn/problems/count-substrings-that-differ-by-one-character/
 */

/**
 * @author zhouhao
 * @date 2023/3/27 12:36
 */
public class CountSubstrings {
    // 这题需要研究研究
    static class Solution {
        public int countSubstrings(String s, String t) {
            int m = s.length(), n = t.length();
            int[][] dpLeft = new int[m + 1][n + 1];
            int[][] dpRight = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dpLeft[i + 1][j + 1] = s.charAt(i) == t.charAt(j) ? (dpLeft[i][j] + 1) : 0;
                }
            }
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    dpRight[i][j] = s.charAt(i) == t.charAt(j) ? dpRight[i + 1][j + 1] + 1 : 0;
                }
            }
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (s.charAt(i) != t.charAt(j)) {
                        int count = (dpLeft[i][j] + 1) * (dpRight[i + 1][j + 1] + 1);
                        ans = Math.max(ans, ans + count);
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "aba", t = "baba";
        System.out.println(new Solution().countSubstrings(s, t));
    }
}
