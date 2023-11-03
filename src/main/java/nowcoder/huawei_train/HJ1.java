package nowcoder.huawei_train;
/*
 华为机试
字符串最后一个单词的长度 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：782190
本题知识点： 字符串
 算法知识视频讲解
校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
题目描述
计算字符串最后一个单词的长度，单词以空格隔开。
输入描述:
一行字符串，非空，长度小于5000。

输出描述:
整数N，最后一个单词的长度。

示例1
输入
复制
hello world
输出
复制
5
 */

import java.util.Scanner;

public class HJ1 {
    public void solution(String s) {
        String[] words = s.split(" ");
        System.out.println(words[words.length - 1].length());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            new HJ1().solution(scanner.nextLine());
        }
    }
}
