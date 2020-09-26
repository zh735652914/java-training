package nowcoder.huawei_train;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：646171
本题知识点： 字符串 哈希
 算法知识视频讲解
校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
题目描述
写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。

输入描述:
第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。

输出描述:
输出输入字符串中含有该字符的个数。

示例1
输入
复制
ABCDEF
A
输出
复制
1
 */

import java.util.Scanner;

public class HJ2 {
    public void solution(String s, String x) {
        int ans = 0;
        s = s.toLowerCase();
        x = x.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (x.charAt(0) == s.charAt(i)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            new HJ2().solution(scanner.nextLine(), scanner.nextLine());
        }
    }
}
