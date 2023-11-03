package leetcode;
/*
题目描述
评论 (2.4k)
题解(2015)
提交记录
5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
通过次数399,483提交次数1,244,102
 */

import java.util.Scanner;

public class longestPalindrome {
    static class Solution {
        int maxLen;

        public String longestPalindrome(String s) {
            maxLen = 0;
            String ans = "";
            for (int i = 0; i < s.length(); i++) {
                String tmp1 = expland(s, i, i);
                String tmp2 = expland(s, i, i + 1);
                if (tmp1.length() > ans.length()) {
                    ans = tmp1;
                }
                if (tmp2.length() > ans.length()) {
                    ans = tmp2;
                }
            }
            return ans;
        }

        private String expland(String s, int left, int right) {
            String ans = "";
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }
            left++;
            right--;
            if (right - left + 1 > maxLen) {
                ans = s.substring(left, right + 1);
                maxLen = left - right + 1;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().longestPalindrome(scanner.nextLine()));
        }
    }
}
