package LeetCode.ProgrammerInterview;
/*
面试题 01.09. String Rotation LCCI
Given two strings, s1 and s2, write code to check if s2 is a rotation of s1
(e.g.,"waterbottle" is a rotation of"erbottlewat"). Can you use only one call
to the method that checks if one word is a substring of another?

Example 1:

Input: s1 = "waterbottle", s2 = "erbottlewat"
Output: True
Example 2:

Input: s1 = "aa", "aba"
Output: False


Note:

0 <= s1.length, s1.length <= 100000
通过次数3,018提交次数5,551
 */

import java.util.Scanner;

//自己傻逼了。。
public class isFlipedString {
    static class Solution {
        public boolean isFlipedString(String s1, String s2) {
            if (s1.length() != s2.length()) return false;
            return s1.equals(s2) || (s1 + s1).contains(s2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().isFlipedString(scanner.nextLine(), scanner.nextLine()));
        }
    }
}
