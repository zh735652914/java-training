package leetcode;
/*
395. Longest Substring with At Least K Repeating Characters
Medium

1100

96

Add to List

Share
Find the length of the longest substring T of a given string (consists of lowercase letters only)
such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
Accepted
64,986
Submissions
161,739
 */


import java.util.Arrays;

public class LongestSubstring {
    //实在是看不懂啊。、。。。。。。。。。
    static class Solution0 {
        public int longestSubstring(String s, int k) {
            int d = 0;

            for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++)
                d = Math.max(d, longestSubstringWithNUniqueChars(s, k, numUniqueTarget));

            return d;
        }

        private int longestSubstringWithNUniqueChars(String s, int k, int numUniqueTarget) {
            int[] map = new int[128];
            int numUnique = 0; // counter 1
            int numNoLessThanK = 0; // counter 2
            int begin = 0, end = 0;
            int d = 0;

//            System.out.println("numUniqueTarget= " + numUniqueTarget);

            while (end < s.length()) {
                if (map[s.charAt(end)]++ == 0) numUnique++; // increment map[c] after this statement
                if (map[s.charAt(end++)] == k) numNoLessThanK++; // inc end after this statement

                while (numUnique > numUniqueTarget) {
                    if (map[s.charAt(begin)]-- == k) numNoLessThanK--; // decrement map[c] after this statement
                    if (map[s.charAt(begin++)] == 0) numUnique--; // inc begin after this statement
                }

//                System.out.println("begin= " + begin + " end= " + end);
                // if we found a string where the number of unique chars equals our target
                // and all those chars are repeated at least K times then update max
                if (numUnique == numUniqueTarget && numUnique == numNoLessThanK) {
//                    System.out.println("begin= " + begin + " end= " + end);
                    d = Math.max(end - begin, d);
                }

            }

            return d;
        }
    }

    static class Solution {
        int[] count = new int[26];

        public int longestSubstring(String s, int k) {
            return substring(s, k, 0, s.length() - 1);
        }

        private int substring(String s, int k, int begin, int end) {
            if (begin > end) return 0;
            Arrays.fill(count, 0);
            boolean flag = false;
            for (int i = begin; i <= end; i++) {
                count[s.charAt(i) - 'a']++;
                if (count[s.charAt(i) - 'a'] >= k) {
                    flag = true;
                }
            }
            if (!flag) return 0;
            for (int i = begin; i <= end; i++) {
                if (count[s.charAt(i) - 'a'] < k) {
                    return Math.max(substring(s, k, begin, i - 1), substring(s, k, i + 1, end));
                }
            }
            return end - begin + 1;
        }
    }

    public static void main(String[] args) {
//        String s = "ababacb";
        String s = "aaabb";
        int k = 3;
        System.out.println(new Solution().longestSubstring(s, k));
    }
}
