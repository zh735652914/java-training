package leetcode.tooffer;
/*
面试题44. 数字序列中某一位的数字
数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

请写一个函数，求任意第n位对应的数字。



示例 1：

输入：n = 3
输出：3
示例 2：

输入：n = 11
输出：0


限制：

0 <= n < 2^31
注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/

通过次数1,465提交次数3,899
 */

import java.util.Scanner;

//还是不会写。。。。又是看了Discuss后才会的。。。
public class findNthDigit {
    static class Solution {
        public int findNthDigit(int n) {
            int len = 1;
            int start = 1;
            long base = 9;
            while (n > len * base) {
                n -= len * base;
                start *= 10;
                len++;
                base *= 10;
            }
            int num = start + (n - 1) / len;
            int index = (n - 1) % len;
            return Integer.parseInt(String.valueOf(String.valueOf(num).charAt(index)));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().findNthDigit(scanner.nextInt()));
        }
    }
}
