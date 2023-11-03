package nowcoder.huawei_train;
/*
 华为机试
句子逆序 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：269016
本题知识点： 数组
 算法知识视频讲解
校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
题目描述
将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
public String reverse(String sentence);

输入描述:
将一个英文语句以单词为单位逆序排放。

输出描述:
得到逆序的句子

示例1
输入
复制
I am a boy
输出
复制
boy a am I
 */

import java.util.Scanner;
import java.util.Stack;

public class HJ13 {
    static public String reverse(String sentence) {
        String[] words = sentence.split(" ");
        Stack<String> stack = new Stack<>();
        for (String word : words) {
            stack.push(word);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop()).append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(reverse(scanner.nextLine()));
        }
    }
}
