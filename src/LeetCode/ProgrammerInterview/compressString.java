package LeetCode.ProgrammerInterview;
/*
面试题 01.06. Compress String LCCI
Implement a method to perform basic string compression using the counts of repeated characters.
 For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become
 smaller than the original string, your method should return the original string. You can assume the string
 has only uppercase and lowercase letters (a - z).

Example 1:

Input: "aabcccccaaa"
Output: "a2b1c5a3"
Example 2:

Input: "abbccd"
Output: "abbccd"
Explanation:
The compressed string is "a1b2c2d1", which is longer than the original string.


Note:

0 <= S.length <= 50000
通过次数25,531提交次数52,091
 */

import java.util.Scanner;

public class compressString {
    static class Solution {
        public String compressString(String S) {
            if (S == null || S.length() == 0) return S;
            StringBuilder stringBuilder = new StringBuilder();
            int pos = 1, count = 1;
            char last = S.charAt(0);
            while (pos < S.length()) {
                if (last == S.charAt(pos)) {
                    count++;
                } else {
                    stringBuilder.append(last);
                    stringBuilder.append(count);
                    last = S.charAt(pos);
                    count = 1;
                }
                pos++;
            }
            stringBuilder.append(last);
            stringBuilder.append(count);
            String ans = stringBuilder.toString();
            return ans.length() < S.length() ? ans : S;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().compressString(scanner.nextLine()));
        }
    }
}
