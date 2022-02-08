package Beijing;
/*
https://leetcode-cn.com/problems/multiply-strings/
 */

public class MultiplyStrings {
    static class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            String last = "";
            for (int i = 0; i < num2.length(); i++) {
                last = last + "0";
                String tmp = multip(num1, num2.charAt(i));
                last = add(last, tmp);
            }
            return last;
        }

        public void test() {
            System.out.println(add("15", "16"));
            System.out.println(multiply("15", "2"));
        }

        private String multip(String num1, char num2) {
            int pos = num1.length() - 1;
            int carry = 0, sum = 0;
            int x = num2 - '0';
            StringBuilder stringBuilder = new StringBuilder();
            while (pos >= 0) {
                sum = (num1.charAt(pos) - '0') * x + carry;
                carry = sum / 10;
                stringBuilder.append(sum % 10);
                pos--;
            }
            while (carry > 0) {
                stringBuilder.append(carry % 10);
                carry /= 10;
            }
            return stringBuilder.reverse().toString();
        }

        private String add(String num1, String num2) {
            int a = num1.length() - 1, b = num2.length() - 1;
            int carry = 0, sum = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while (a >= 0 && b >= 0) {
                sum = (num1.charAt(a) - '0') + (num2.charAt(b) - '0') + carry;
                carry = sum / 10;
                stringBuilder.append(sum % 10);
                a--;
                b--;
            }
            while (a >= 0) {
                sum = num1.charAt(a) - '0' + carry;
                carry = sum / 10;
                stringBuilder.append(sum % 10);
                a--;
            }
            while (b >= 0) {
                sum = num2.charAt(b) - '0' + carry;
                carry = sum / 10;
                stringBuilder.append(sum % 10);
                b--;
            }
            while (carry > 0) {
                stringBuilder.append(carry % 10);
                carry /= 10;
            }
            return stringBuilder.reverse().toString();
        }
    }

    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        new Solution().test();
        System.out.println(new Solution().multiply(num1, num2));
    }
}
