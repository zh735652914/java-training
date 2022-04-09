package Beijing;
/*
https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 */

import java.util.HashMap;
import java.util.Map;

// 这题写到自闭
public class fractionToDecimal {
    static class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            long numeratorLong = numerator;
            long denominatorLong = denominator;
            StringBuilder stringBuilder = new StringBuilder();
            if (numeratorLong % denominatorLong == 0) {
                return stringBuilder.append(numeratorLong / denominatorLong).toString();
            }
            if ((numeratorLong < 0) ^ (denominatorLong < 0)) {
                stringBuilder.append('-');
            }
            numeratorLong = Math.abs(numeratorLong);
            denominatorLong = Math.abs(denominatorLong);
            long integerPart = numeratorLong / denominatorLong;
            stringBuilder.append(integerPart);
            stringBuilder.append('.');
            StringBuilder fractionPart = new StringBuilder();
            Map<Long, Integer> map = new HashMap<>();
            long remainder = numeratorLong % denominatorLong;
            int index = 0;
            while (remainder != 0 && !map.containsKey(remainder)) {
                map.put(remainder, index);
                remainder *= 10;
                fractionPart.append(remainder / denominatorLong);
                remainder %= denominatorLong;
                index++;
            }
            if (remainder != 0) {
                int insert = map.get(remainder);
                fractionPart.insert(insert, '(');
                fractionPart.append(')');
            }
            return stringBuilder.append(fractionPart).toString();
        }
    }

    public static void main(String[] args) {
        int numerator = -50, denominator = 8;
        System.out.println(new Solution().fractionToDecimal(numerator, denominator));
    }
}
