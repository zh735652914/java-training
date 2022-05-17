package Beijing.hot100;
/*
https://leetcode.cn/problems/longest-palindromic-substring/
 */

public class longestPalindromicSubstring {
    // 看了评论后优化的版本；把回文看成中间的部分全是同一字符，左右部分相对称
    static class Solution {
        private int start, end;

        public String longestPalindrome(String s) {
            start = 0;
            end = 0;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                i = expend(s, i, i);
            }
            return s.substring(start, end + 1);
        }

        private int expend(String s, int left, int right) {
            int len = s.length();
            while (right < len && s.charAt(right) == s.charAt(left)) {
                right++;
            }
            right--;
            int pos = right;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            if (right - left > end - start) {
                start = left;
                end = right;
            }
            return pos;
        }
    }

    // 最简单的版本的，基本就是暴力
    static class Solution0 {
        private int maxLen, start, end;

        public String longestPalindrome(String s) {
            maxLen = 1;
            start = 0;
            end = 0;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                expend(s, i, i);
                expend(s, i, i + 1);
            }
            return s.substring(start, end + 1);
        }

        private void expend(String s, int left, int right) {
            int len = s.length();
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            if (left > right) {
                return;
            }
            if (maxLen <= (right - left + 1)) {
                maxLen = right - left + 1;
                start = left;
                end = right;
            }
        }
    }

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(new Solution().longestPalindrome(s));
    }
}
