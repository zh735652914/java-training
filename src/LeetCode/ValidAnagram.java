package LeetCode;
/*
242. Valid Anagram
Easy

1046

126

Add to List

Share
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

class ValidAnagramSolution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] hash = new int[27];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (hash[t.charAt(i) - 'a']-- <= 0) return false;
//            hash[t.charAt(i) - 'a']--;
        }
        return true;
    }
}

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
//        String s = "aacc", t = "ccac";
        System.out.println(new ValidAnagramSolution().isAnagram(s, t));
    }
}
