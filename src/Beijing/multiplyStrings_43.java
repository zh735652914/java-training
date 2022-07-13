package Beijing;
/*
https://leetcode.cn/problems/multiply-strings/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 写起来很累
public class multiplyStrings_43 {
    static class Solution {
        public String multiply(String num1, String num2) {
//            test();
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            List<Character> sum = new LinkedList<>();
            List<Character> x = new ArrayList<>(num1.length());
            for (int i = 0; i < num1.length(); i++) {
                x.add(num1.charAt(i));
            }
            int len = num2.length();
            for (int i = 0; i < len; i++) {
                sum.add('0');
                sum = strAdd(sum, strMultiply(x, num2.charAt(i) - '0'));
            }
            StringBuilder ans = new StringBuilder();
            for (char ch : sum) {
                ans.append(ch);
            }
            return ans.toString();
        }

        public void test() {
            List<Character> num1 = new ArrayList<>();
            List<Character> num2 = new ArrayList<>();
            num1.add('1');
            num1.add('0');
            num2.add('9');
            num2.add('0');
            System.out.println("add: " + strAdd(num1, num2));
            System.out.println("multiply: " + strMultiply(num1, 9));
        }

        private List<Character> strAdd(List<Character> num1, List<Character> num2) {
            int len1 = num1.size(), len2 = num2.size();
            List<Character> SUM = new LinkedList<>();
            int carry = 0;
            int i = 0;
            for (i = 0; i < len1 && i < len2; i++) {
                int sum = (num1.get(len1 - 1 - i) - '0') + (num2.get(len2 - 1 - i) - '0') + carry;
                SUM.add(0, (char) ('0' + sum % 10));
                carry = sum / 10;
            }
            while (i < len1) {
                int sum = (num1.get(len1 - 1 - i) - '0') + carry;
                SUM.add(0, (char) ('0' + sum % 10));
                carry = sum / 10;
                i++;
            }
            while (i < len2) {
                int sum = (num2.get(len2 - 1 - i) - '0') + carry;
                SUM.add(0, (char) ('0' + sum % 10));
                carry = sum / 10;
                i++;
            }
            while (carry > 0) {
                SUM.add(0, (char) ('0' + carry % 10));
                carry /= 10;
            }
            return SUM;
        }

        private List<Character> strMultiply(List<Character> num1, int x) {
            List<Character> SUM = new LinkedList<>();
            int len = num1.size();
            int carry = 0;
            for (int i = len - 1; i >= 0; i--) {
                int sum = x * (num1.get(i) - '0') + carry;
                SUM.add(0, (char) ('0' + sum % 10));
                carry = sum / 10;
            }
            while (carry > 0) {
                SUM.add(0, (char) ('0' + carry % 10));
                carry /= 10;
            }
            return SUM;
        }
    }

    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
//        String num1 = "12", num2 = "11";
        System.out.println(new Solution().multiply(num1, num2));
    }
}
