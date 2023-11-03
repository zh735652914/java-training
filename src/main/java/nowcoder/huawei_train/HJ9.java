package nowcoder.huawei_train;
/*
 华为机试
提取不重复的整数 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：252937
本题知识点： 数组 位运算 哈希
 算法知识视频讲解
校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
题目描述
输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。

输入描述:
输入一个int型整数

输出描述:
按照从右向左的阅读顺序，返回一个不含重复数字的新的整数

示例1
输入
复制
9876673
输出
复制
37689
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ9 {
    public static void solution(int x) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        while (x > 0) {
            int cur = x % 10;
            x /= 10;
            if (!set.contains(cur)) {
                ans += cur;
                set.add(cur);
                ans *= 10;
            }

        }
        System.out.println(ans / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            solution(scanner.nextInt());
        }
    }
}
