package nowcoder.huawei_train;
/*
 华为机试
质数因子 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：349296
本题知识点： 排序
 算法知识视频讲解
校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
题目描述
功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）

最后一个数后面也要有空格

输入描述:
输入一个long型整数

输出描述:
按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。

示例1
输入
复制
180
输出
复制
2 2 3 3 5
 */

import java.util.Scanner;

public class HJ6 {
    public void solution(long x) {
        StringBuilder ans = new StringBuilder();
        while (x > 1) {
            for (int i = 2; i <= x; i++) {
                if (x % i == 0) {
                    x /= i;
                    ans.append(i).append(" ");
                    break;
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            new HJ6().solution(scanner.nextLong());
        }
    }
}
