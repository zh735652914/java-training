package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

class LongestSubstringWithoutRepeatingCharactersSolution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (list.size() == 0) {
                list.add(s.charAt(i));
                if (i == 0) {
                    len = 1;
                }
                continue;
            }
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
            } else {
                int pos = list.indexOf(s.charAt(i));
                while (pos >= 0) {
                    list.remove(0);
                    pos--;
                }
                list.add(s.charAt(i));
            }
            if (list.size() > len) {
                len = list.size();
            }
        }
        return len;
    }
}

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstringWithoutRepeatingCharactersSolution longestSubstringWithoutRepeatingCharactersSolution = new LongestSubstringWithoutRepeatingCharactersSolution();
        System.out.println(longestSubstringWithoutRepeatingCharactersSolution.lengthOfLongestSubstring(s));
    }
}
