package beijing;
/*
https://leetcode.cn/problems/roman-to-integer/
 */

// 自己写的不太顺了
public class romantoInteger_13_topInterviewList {
    static class Solution {
        public int romanToInt(String s) {
            int len = s.length();
            if (len == 1) {
                return getNum(s.charAt(0));
            }
            int left = 0, right = 1;
            int ans = 0;
            while (right < len) {
                int x = getNum(s.charAt(left));
                int y = getNum(s.charAt(right));
                if (x < y) {
                    ans += y - x;
                    left += 2;
                    right += 2;
                } else {
                    ans += x;
                    left++;
                    right++;
                }
            }
            if (left < len) {
                ans += getNum(s.charAt(left));
            }
            return ans;
        }

        private int getNum(char x) {
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
            }
            return 0;
        }
    }

    /*
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
     */
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new Solution().romanToInt(s));
    }
}
