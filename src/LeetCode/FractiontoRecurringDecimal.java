package LeetCode;
/*
166. Fraction to Recurring Decimal
Medium

635

1379

Add to List

Share
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//自己写的各种错误，而且特别智障。。。
//自己写的太智障了，而且一直错
//class FractiontoRecurringDecimalSulotion {
//    private boolean point = false;
//    //    private int NUM;
////    private List<Integer> N = new ArrayList<>();
//    private Map<Integer, Integer> map = new HashMap<>();
//
//    public String fractionToDecimal(int numerator, int denominator) {
//        if (denominator == 0) return null;
////        this.NUM = numerator;
////        N.add(numerator);
//        int len = 0;
////        String reap="";
//        StringBuilder ans = new StringBuilder();
//        if (numerator < denominator) {
//            point = true;
//            ans.append("0.");
//            len = 2;
//        }
////        map.put(numerator, len);
//        backtrack(numerator, denominator, ans, len);
//        return ans.toString();
//    }
//
//    private void backtrack(int numerator, int denominator, StringBuilder ans, int len) {
//        if (numerator == 0) return;
////        int tmpNumerator = numerator;
//        boolean flag = false;
//        while (numerator < denominator) {
//            if (point) {
//
//                numerator *= 10;
//            } else {
//                point = true;
//                ans.append(".");
//                numerator *= 10;
//            }
//            if (flag) {
//                map.put(numerator / 10, len);
//                ans.append("0");
//            } else {
//                flag = true;
//            }
//        }
//
//        String tmp = String.valueOf(numerator / denominator);
//        numerator = numerator % denominator;
//
//        if (map.containsKey(numerator)) {
//            ans.append(tmp);
//            tmp = ans.toString().substring(map.get(numerator));
//            ans.append("(");
////            ans.append(tmp);
//            ans.delete(map.get(numerator), map.get(numerator) + tmp.length());
//            ans.append(tmp);
//            ans.append(")");
//            return;
//        } else if (PUT(numerator) == -1) {
//            ans.append(tmp);
//            len += tmp.length();
//            map.put(numerator, len);
//        }
//
////        int tmpNumerator = numerator;
////        while (!map.containsKey(tmpNumerator) || tmpNumerator >= 0) {
////
////            tmpNumerator /= 10;
////        }
//
//        backtrack(numerator, denominator, ans, len);
//    }
//
//    private int PUT(int numerator) {
//        if (numerator == 0) return -1;
//        if (map.containsKey(numerator)) return map.get(numerator);
//        map.put(numerator, PUT(numerator / 10));
//        return map.get(numerator);
//    }
//}

//看了Discuss写的。。。这是一道让人崩溃的题目！！！
class FractiontoRecurringDecimalSulotion {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder ans = new StringBuilder();
        ans.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long Numerator = Math.abs((long) numerator);
        long Denominator = Math.abs((long) denominator);
        ans.append(Numerator / Denominator);
        Numerator %= Denominator;
        if (Numerator == 0) return ans.toString();
        ans.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(Numerator, ans.length());
        while (Numerator != 0) {
            Numerator *= 10;
            ans.append(Numerator / Denominator);
            Numerator %= Denominator;
            if (map.containsKey(Numerator)) {
                ans.insert(map.get(Numerator), "(");
                ans.append(")");
                break;
            } else {
                map.put(Numerator, ans.length());
            }
        }
        return ans.toString();
    }
}

public class FractiontoRecurringDecimal {
    public static void main(String[] args) {
//        int numerator = 2;
//        int denominator = 30;
        int numerator = -1;
        int denominator = -2147483648;
        System.out.println(new FractiontoRecurringDecimalSulotion().fractionToDecimal(numerator, denominator));
    }
}
