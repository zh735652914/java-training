package leetcode.programmerInterview;
/*
面试题 01.02. Check Permutation LCCI
Given two strings,write a method to decide if one is a permutation of the other.

Example 1:

Input: s1 = "abc", s2 = "bca"
Output: true
Example 2:

Input: s1 = "abc", s2 = "bad"
Output: false
Note:

0 <= len(s1) <= 100
0 <= len(s2) <= 100
通过次数5,908提交次数8,584
 */

import java.util.Scanner;

public class CheckPermutation {
    static class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            int[] CH = new int[256];
            for (int i = 0; i < s1.length(); i++) {
                CH[s1.charAt(i)]++;
            }
            for (int i = 0; i < s2.length(); i++) {
                if (CH[s2.charAt(i)]-- == 0) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            System.out.println(new Solution().CheckPermutation(s1, s2));
        }
    }
}
