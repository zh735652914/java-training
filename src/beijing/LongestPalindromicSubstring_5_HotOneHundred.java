package beijing;
/*
https://leetcode.cn/problems/longest-palindromic-substring/
 */

/**
 * @author zhouhao
 * @date 2023/3/8 13:05
 */
// 本来想用简单算法，结果发现旧算法自己都不太会了
public class LongestPalindromicSubstring_5_HotOneHundred {
    static class Solution {
        private int maxLen;
        private int L, R;

        public String longestPalindrome(String s) {
            maxLen = 0;
            L = 0;
            R = 0;
            for (int i = 0; i < s.length(); i++) {
                getPalindrome(s, i, i);
                getPalindrome(s, i, i + 1);
            }
            return s.substring(L, R + 1);
        }

        private void getPalindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                L = left;
                R = right;
            }
        }
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Solution().longestPalindrome(s));
    }
}
