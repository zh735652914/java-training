package Beijing;
/*
https://leetcode.cn/problems/fraction-addition-and-subtraction/
 */

// 自己不会写，主要是gcd函数不会
public class fractionAdditionandSubtraction_592 {
    static class Solution {
        public String fractionAddition(String expression) {
            long denominator = 0, numerator = 1; // 分子，分母
            int index = 0, n = expression.length();
            while (index < n) {
                long denominator1 = 0, sign = 1;
                while (index < n && expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                    sign = expression.charAt(index) == '-' ? -1 : 1;
                    index++;
                }
                while (index < n && Character.isDigit(expression.charAt(index))) {
                    denominator1 *= 10;
                    denominator1 += expression.charAt(index) - '0';
                    index++;
                }
                denominator1 *= sign;
                long numerator1 = 0;
                index++;
                while (index < n && Character.isDigit(expression.charAt(index))) {
                    numerator1 *= 10;
                    numerator1 += expression.charAt(index) - '0';
                    index++;
                }
                denominator = numerator * denominator1 + numerator1 * denominator;
                numerator *= numerator1;
            }
            if (denominator == 0) {
                return "0/1";
            }
            long g = gcd(numerator, Math.abs(denominator));
            return denominator / g + "/" + numerator / g;
        }

        private long gcd(long a, long b) {
            long remainder = a % b;
            while (remainder != 0) {
                a = b;
                b = remainder;
                remainder = a % b;
            }
            return b;
        }
    }

    public static void main(String[] args) {
        String expression = "-1/2+1/2";
        System.out.println(new Solution().fractionAddition(expression));
    }
}
