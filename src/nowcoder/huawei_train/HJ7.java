package nowcoder.huawei_train;
/*
 华为机试
取近似值 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：229113
本题知识点： 数学 语法题
 算法知识视频讲解
校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
题目描述
写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。

输入描述:
输入一个正浮点数值

输出描述:
输出该数值的近似整数值

示例1
输入
复制
5.5
输出
复制
6
 */

import java.util.Scanner;

public class HJ7 {
    public static void solution(float x) {
        float res = x - (float) (int) x;
        System.out.println(res >= 0.5 ? (int) x + 1 : (int) x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            solution(scanner.nextFloat());
        }
    }
}
