package LeetCode.ProgrammerInterview;
/*
面试题 01.05. One Away LCCI
There are three types of edits that can be performed on strings: insert a character, remove a character,
 or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.



Example 1:

Input:
first = "pale"
second = "ple"
Output: True
Example 2:

Input:
first = "pales"
second = "pal"
Output: False
通过次数2,783提交次数8,940
 */

import java.util.Scanner;

public class oneEditAway {
    static class Solution {
        public boolean oneEditAway(String first, String second) {
            if (Math.abs(first.length() - second.length()) > 1) return false;
            boolean diff = false;
            for (int i = 0, j = 0; i < first.length() && j < second.length(); ) {
                if (first.charAt(i) == second.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if (diff) return false;
                    diff = true;
                    if (first.length() == second.length()) {
                        i++;
                        j++;
                    } else if (first.length() > second.length()) {
                        i++;
                    } else {
                        j++;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().oneEditAway(scanner.nextLine(), scanner.nextLine()));
        }
    }
}
