package nowcoder;
/*
 牛客题霸-名企高频面试题
大数加法
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 256M，其他语言512M 热度指数：480
本题知识点： 字符串 模拟
 算法知识视频讲解
题目描述
以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
（字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
示例1
输入
复制
"1","99"
输出
复制
"100"
说明
1+99=100
 */

public class NC1 {
    static public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 计算两个数之和
         *
         * @param s string字符串 表示第一个整数
         * @param t string字符串 表示第二个整数
         * @return string字符串
         */
        public String solve(String s, String t) {
            int carry = 0;
            StringBuilder stringBuilder = new StringBuilder();
            int index = 0;
            for (index = 0; index < s.length() && index < t.length(); index++) {
                int x = s.charAt(s.length() - 1 - index) - '0';
                int y = t.charAt(t.length() - 1 - index) - '0';
                int sum = x + y + carry;
                carry = sum / 10;
                stringBuilder.append(sum % 10);
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
    }

    public static void main(String[] args) {
        String s = "1";
        String t = "99";
        System.out.println(new Solution().solve(s, t));
    }
}
