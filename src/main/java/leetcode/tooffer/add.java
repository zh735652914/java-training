package leetcode.tooffer;
/*
面试题65. 不用加减乘除做加法
写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。



示例:

输入: a = 1, b = 1
输出: 2


提示：

a, b 均可能是负数或 0
结果不会溢出 32 位整数
通过次数2,911提交次数5,436
 */

import java.util.Scanner;

//不会写。。。
public class add {
    static class Solution {
        public int add(int a, int b) {
            while (b != 0) {
                int tmp = a ^ b;
                b = (a & b) << 1;
                a = tmp;
            }
            return a;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new Solution().add(scanner.nextInt(), scanner.nextInt()));
    }
}
