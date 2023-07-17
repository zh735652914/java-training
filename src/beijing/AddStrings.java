package beijing;
/*
https://leetcode.cn/problems/add-strings/
 */

/**
 * @author zhouhao
 * @date 2023/7/17 12:46
 */
// 模式化的题目了
public class AddStrings {
    static class Solution {
        public String addStrings(String num1, String num2) {
            int a = num1.length() - 1, b = num2.length() - 1;
            int carry = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while (a >= 0 && b >= 0) {
                int sum = num1.charAt(a) - '0' + num2.charAt(b) - '0' + carry;
                carry = sum / 10;
                stringBuilder.append(sum % 10);
                a--;
                b--;
            }
            while (a >= 0) {
                int sum = num1.charAt(a) - '0' + carry;
                carry = sum / 10;
                stringBuilder.append(sum % 10);
                a--;
            }
            while (b >= 0) {
                int sum = num2.charAt(b) - '0' + carry;
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
        String num1 = "11", num2 = "123";
        System.out.println(new Solution().addStrings(num1, num2));
    }
}
