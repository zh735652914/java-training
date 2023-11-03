package nowcoder.huawei_train;
/*
 华为机试
字符串分隔 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：508777
本题知识点： 字符串
 算法知识视频讲解
校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
题目描述
•连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
•长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
输入描述:
连续输入字符串(输入2次,每个字符串长度小于100)

输出描述:
输出到长度为8的新字符串数组

示例1
输入
复制
abc
123456789
输出
复制
abc00000
12345678
90000000
 */

import java.util.Scanner;

public class HJ4 {
    static public void solution(String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        if (s.length() < 8) {
            StringBuilder stringBuilder = new StringBuilder(s);
            for (int i = s.length(); i < 8; i++) {
                stringBuilder.append('0');
            }
            System.out.println(stringBuilder);
        } else {
            System.out.println(s.substring(0, 8));
            solution(s.substring(8));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            solution(scanner.nextLine());
        }
    }
}
