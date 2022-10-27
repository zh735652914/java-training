package Beijing;
/*
https://leetcode.cn/problems/fraction-to-recurring-decimal/
 */

import java.util.HashMap;
import java.util.Map;

// 自己还是不会写，自闭
public class FractiontoRecurringDecimal_166_topInterviewList {
    static class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            long lNumerator = numerator;
            long lDenominator = denominator;
            if (lNumerator % lDenominator == 0) {
                return String.valueOf(lNumerator / lDenominator);
            }
            boolean postive = (lNumerator ^ lDenominator) >= 0;
            lNumerator = Math.abs(lNumerator);
            lDenominator = Math.abs(lDenominator);
            long integerPart = lNumerator / lDenominator;
            StringBuilder ans = new StringBuilder();
            if (!postive) {
                ans.append('-');
            }
            ans.append(integerPart);
            ans.append('.');
            StringBuilder fractionPart = new StringBuilder();
            Map<Long, Integer> map = new HashMap<>();
            long remainder = lNumerator % lDenominator;
            int index = 0;
            while (remainder != 0 && !map.containsKey(remainder)) {
                map.put(remainder, index);
                index++;
                remainder *= 10;
                fractionPart.append(remainder / lDenominator);
                remainder %= lDenominator;
            }
            if (map.containsKey(remainder)) {
                int pos = map.get(remainder);
                fractionPart.insert(pos, '(');
                fractionPart.append(')');
            }
            return ans.append(fractionPart).toString();
        }
    }

    public static void main(String[] args) {
        int numerator = -2147483648, denominator = -1;
        System.out.println(new Solution().fractionToDecimal(numerator, denominator));
    }
}
