package LeetCode;
/*
647. Palindromic Substrings
Medium

1836

94

Favorite

Share
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings
even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".


Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Note:

The input string length won't exceed 1000.
 */

//自己不会写。。。看了discuss后才写出来的。。。
class PalindromicSubstringsSolution {
    public int countSubstrings(String s) {
        if (s == null || s.length() <= 0) return 0;
        int count = 0;
        for (int index = 0; index < s.length(); index++) {
            count += extend(s, index, index);
            count += extend(s, index, index + 1);
        }
        return count;
    }

    private int extend(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new PalindromicSubstringsSolution().countSubstrings(s));
    }
}
