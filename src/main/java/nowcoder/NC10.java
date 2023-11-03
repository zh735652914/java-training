package nowcoder;
/*
 牛客题霸-名企高频面试题
大数乘法
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 256M，其他语言512M 热度指数：312
 算法知识视频讲解
题目描述
以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
（字符串长度不大于10000，保证字符串仅由'0'~'9'这10种字符组成）
示例1
输入
复制
"11","99"
输出
复制
"1089"
说明
11*99=1089
 */

public class NC10 {
    static public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param s string字符串 第一个整数
         * @param t string字符串 第二个整数
         * @return string字符串
         */
        public String solve(String s, String t) {
            if (s.length() < t.length()) {
                String tmp = s;
                s = t;
                t = tmp;
            }
            String ans = "";
            for (int i = 0; i < t.length(); i++) {
                ans = add(ans, multi(s, t.charAt(t.length() - 1 - i), i));
            }
            return ans;
        }

        private String add(String s, String t) {
            StringBuilder stringBuilder = new StringBuilder();
            int carry = 0;
            int index = 0;
            while (index < s.length() && index < t.length()) {
                int sum = s.charAt(s.length() - 1 - index) - '0' + t.charAt(t.length() - 1 - index) - '0' + carry;
                stringBuilder.append(sum % 10);
                carry = sum / 10;
                index++;
            }
            while (index < s.length()) {
                int sum = s.charAt(s.length() - 1 - index++) - '0' + carry;
                stringBuilder.append(sum % 10);
                carry = sum / 10;
            }
            while (index < t.length()) {
                int sum = t.charAt(t.length() - 1 - index++) - '0' + carry;
                stringBuilder.append(sum % 10);
                carry = sum / 10;
            }
            while (carry > 0) {
                stringBuilder.append(carry % 10);
                carry /= 10;
            }
            return stringBuilder.reverse().toString();
        }

        private String multi(String s, char t, int count) {
            int carry = 0, x = t - '0';
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                int sum = (s.charAt(s.length() - 1 - i) - '0') * x + carry;
                stringBuilder.append(sum % 10);
                carry = sum / 10;
            }
            while (carry > 0) {
                stringBuilder.append(carry % 10);
                carry /= 10;
            }
            stringBuilder.reverse();
            for (int i = 0; i < count; i++) {
                stringBuilder.append(0);
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        String s = "733064366";
        String t = "459309139";
        System.out.println(new Solution().solve(s, t));
    }
}
