package Beijing;
/*
https://leetcode.cn/problems/string-to-integer-atoi/
 */

// 这题是真没意思
public class stringtoInteger_8 {
    static class Solution {
        public int myAtoi(String s) {
            s = s.trim();
            if (s.length() < 1) {
                return 0;
            }
            char head = s.charAt(0);
            if (head != '+' && head != '-' && !Character.isDigit(head)) {
                return 0;
            }
            boolean positive = head != '-';
            long ans = 0;
            int len = s.length();
            for (int i = Character.isDigit(head) ? 0 : 1; i < len; i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    break;
                }
                ans *= 10;
                ans += s.charAt(i) - '0';
                if (positive && ans >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (!positive && -ans <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            return positive ? (int) ans : (int) -ans;
        }
    }

    public static void main(String[] args) {
        String s = "2147483648";
        System.out.println(new Solution().myAtoi(s));
    }
}
