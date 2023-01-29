package beijing;

/*
https://leetcode-cn.com/problems/roman-to-integer/
 */
public class romanToInt {
    static class Solution {
        public int romanToInt(String s) {
            int ans = 0;
            int left = 0, right = 1;
            int a = 0, b = 0;
            while (right < s.length() && left < s.length()) {
                a = mkNum(s.charAt(left));
                b = mkNum(s.charAt(right));
                if (a >= b) {
                    ans += a;
                    left++;
                    right++;
                } else {
                    ans += b - a;
                    left += 2;
                    right += 2;
                }
            }
            if (left < s.length()) {
                ans += mkNum(s.charAt(left));
            }
            return ans;
        }

        private int mkNum(char x) {
            switch (x) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    return -1;
            }
        }
    }

    public static void main(String[] args) {
        String s = "IVX";
        System.out.println(new Solution().romanToInt(s));
    }
}
