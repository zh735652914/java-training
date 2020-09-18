package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：6963
本题知识点： 双指针 字符串
 算法知识视频讲解
题目描述
写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
示例1
输入
复制
"abcd"
输出
复制
"dcba"
 */

import java.util.Scanner;

public class solve {
    static public class Solution {
        /**
         * 反转字符串
         *
         * @param str string字符串
         * @return string字符串
         */
        public String solve(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                stringBuilder.append(str.charAt(i));
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().solve(scanner.nextLine()));
        }
    }
}
