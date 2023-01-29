package leetcode.programmerInterview;

import java.util.Scanner;

/*
面试题 01.03. String to URL LCCI
Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters,and that you are given the "true" length of the string. (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)

Example 1:

Input: "Mr John Smith ", 13
Output: "Mr%20John%20Smith"
Explanation:
The missing numbers are [5,6,8,...], hence the third missing number is 8.
Example 2:

Input: "               ", 5
Output: "%20%20%20%20%20"


Note:

0 <= S.length <= 500000
通过次数3,989提交次数6,955
 */
public class replaceSpaces {
    static class Solution {
        public String replaceSpaces(String S, int length) {
            char[] ch = S.toCharArray();
            int pos = ch.length - 1, index = length - 1;
            while (index >= 0) {
                if (ch[index] == ' ') {
                    ch[pos--] = '0';
                    ch[pos--] = '2';
                    ch[pos--] = '%';
                } else {
                    ch[pos--] = ch[index];
                }
                index--;
            }
            return String.copyValueOf(ch, pos + 1, ch.length - pos - 1);
        }

        public String replaceSpaces0(String S, int length) {
            char[] ch = new char[S.length()];
            int index = 0, pos = 0;
            for (int i = 0; i < S.length() && index < length; i++, index++) {
                if (S.charAt(i) != ' ') {
                    ch[pos++] = S.charAt(i);
                } else {
                    ch[pos++] = '%';
                    ch[pos++] = '2';
                    ch[pos++] = '0';
                }
            }
            return String.copyValueOf(ch).substring(0, pos);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().replaceSpaces(scanner.nextLine(), scanner.nextInt()));
        }
    }
}
