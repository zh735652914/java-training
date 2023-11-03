package nowcoder.huawei_train;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：453973
本题知识点： 字符串
 算法知识视频讲解
校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
题目描述
写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）

输入描述:
输入一个十六进制的数值字符串。

输出描述:
输出该数值的十进制字符串。

示例1
输入
复制
0xA
输出
复制
10
 */

import java.util.Scanner;

public class HJ5 {
    static public void solution(String s) {
        s = s.substring(2);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans *= 16;
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'F') {
                ans += s.charAt(i) - 'A' + 10;
            } else {
                ans += s.charAt(i) - '0';
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            solution(scanner.nextLine());
        }
    }
}
