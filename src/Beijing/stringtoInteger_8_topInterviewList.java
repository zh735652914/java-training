package Beijing;
/*
https://leetcode.cn/problems/string-to-integer-atoi/
 */

public class stringtoInteger_8_topInterviewList {
    // 总感觉写的不太好
    static class Solution {
        public int myAtoi(String s) {
            s = s.trim();
            int ans = 0;
            boolean positive = true;
            int len = s.length();
            if (len == 0) {
                return 0;
            }
            if (s.charAt(0) == '-') {
                positive = false;
            }
            int i = 0;
            if (s.charAt(0) == '+' || !positive) {
                i = 1;
            }
            int dig = 0;
            for (; i < len; i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    break;
                }
                dig = s.charAt(i) - '0';
                if (positive && ans > Integer.MAX_VALUE / 10 || !positive && -ans < Integer.MIN_VALUE / 10) {
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                ans *= 10;
                if (positive && ans > (Integer.MAX_VALUE - dig) || !positive && -ans < (Integer.MIN_VALUE + dig)) {
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                ans += dig;
            }
            return positive ? ans : -ans;
        }
    }

    public static void main(String[] args) {
        String s = "2147483648";
        System.out.println(new Solution().myAtoi(s));
    }
}
