package beijing;
/*
https://leetcode.cn/problems/valid-palindrome/
 */

public class validPalindrome_125_topInterviewList {
    // 注意数字
    static class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            int len = s.length();
            int left = 0, right = len - 1;
            while (left < right) {
                while (left < right && !Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                    left++;
                }
                while (left < right && !Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                    right--;
                }
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "0P";
        System.out.println(new Solution().isPalindrome(s));
    }
}
