package leetcode.programmerInterview;
/*
面试题 01.01. Is Unique LCCI
Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

Example 1:

Input: s = "leetcode"
Output: false
Example 2:

Input: s = "abc"
Output: true


Note:

0 <= len(s) <= 100
 */

import java.util.Scanner;

public class isUnique {
    static class Solution {
        public boolean isUnique(String astr) {
            boolean[] has = new boolean[26];
            for (int i = 0; i < astr.length(); i++) {
                int pos = Character.toLowerCase(astr.charAt(i)) - 'a';
                if (!has[pos]) {
                    has[pos] = true;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().isUnique(scanner.nextLine()));
        }
    }
}
