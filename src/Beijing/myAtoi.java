package Beijing;
/*
https://leetcode-cn.com/problems/string-to-integer-atoi/
 */

public class myAtoi {
    static class Solution {
        public int myAtoi(String s) {
            s = s.trim();
            if (s.length() < 1) {
                return 0;
            }
            if (s.charAt(0) != '-' && s.charAt(0) != '+' && !Character.isDigit(s.charAt(0))) {
                return 0;
            }
            long ans = 0;
            boolean neg = s.charAt(0) == '-';
            int index = Character.isDigit(s.charAt(0)) ? 0 : 1;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                ans = ans * 10 + s.charAt(index) - '0';
                if (!neg && ans >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                // 这个地方要注意
                if (neg && ans >= Integer.MAX_VALUE + 1L) {
                    return Integer.MIN_VALUE;
                }
                index++;
            }
            return neg ? (int) -ans : (int) ans;
        }
    }

    public static void main(String[] args) {
        String s = "-912834";
        System.out.println(new Solution().myAtoi(s));
    }
}
