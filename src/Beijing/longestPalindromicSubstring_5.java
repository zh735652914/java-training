package Beijing;
/*
https://leetcode.cn/problems/longest-palindromic-substring/
 */

// 第四次写了
public class longestPalindromicSubstring_5 {
    static class Solution {
        private int maxLen;
        private int[] ans;

        public String longestPalindrome(String s) {
            int len = s.length();
            maxLen = 0;
            ans = new int[2];
            for (int i = 0; i < len; i++) {
                getPalindrome(s, i, i);
                getPalindrome(s, i, i + 1);
            }
            return s.substring(ans[0], ans[1] + 1);
        }

        private void getPalindrome(String s, int L, int R) {
            int len = s.length();
            while (L >= 0 && R < len && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            L++;
            R--;
            if (R - L + 1 > maxLen) {
                maxLen = R - L + 1;
                ans[0] = L;
                ans[1] = R;
            }
        }
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Solution().longestPalindrome(s));
    }
}
