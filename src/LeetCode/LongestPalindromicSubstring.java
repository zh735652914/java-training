package LeetCode;

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */
//自己不会写，看了discuss
class LongestPalindromicSubstringSolution {
    //    static int Maxlen = Integer.MIN_VALUE, begin; 这个版本在leetcode上提交无法通过，很奇怪
    private int Maxlen = Integer.MIN_VALUE, begin;

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        for (int i = 0; i < s.length() - 1; i++) {
            palindromic(s, i, i);
            palindromic(s, i, i + 1);
        }
        return s.substring(begin, begin + Maxlen);
    }

    private void palindromic(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (Maxlen < (end - start - 1)) {
            Maxlen = end - start - 1;
            begin = start + 1;
        }
    }
}

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "cbbd";
        LongestPalindromicSubstringSolution longestPalindromicSubstringSolution = new LongestPalindromicSubstringSolution();
        System.out.println(longestPalindromicSubstringSolution.longestPalindrome(s));
    }
}
