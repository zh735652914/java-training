package leetcode;
/*
438. Find All Anagrams in a String
Medium

2024

151

Favorite

Share
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

import java.util.ArrayList;
import java.util.List;

//自己没写出来，感觉自己真是智障！！！
class FindAllAnagramsinaStringSolution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int left = 0, right = 0, count = p.length();
        int[] hash = new int[27];
        for (char x : p.toCharArray()) {
            hash[x - 'a']++;
        }
        while (right < s.length()) {
            if (hash[s.charAt(right++) - 'a']-- > 0) count--;
            if (count == 0) list.add(left);
            if (right - left == p.length() && hash[s.charAt(left++) - 'a']++ >= 0) count++;
        }
        return list;
    }
}

public class FindAllAnagramsinaString {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(new FindAllAnagramsinaStringSolution().findAnagrams(s, p));
    }
}
