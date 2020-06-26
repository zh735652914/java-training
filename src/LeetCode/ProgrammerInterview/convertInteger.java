package LeetCode.ProgrammerInterview;
/*
面试题 05.06. 整数转换
整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。

示例1:

 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 输出：2
示例2:

 输入：A = 1，B = 2
 输出：2
提示:

A，B范围在[-2147483648, 2147483647]之间
通过次数2,903提交次数5,788
 */

import java.util.Scanner;

//这题不难
public class convertInteger {
    static class Solution {
        public int convertInteger(int A, int B) {
            int ans = 0;
            while (A != 0 || B != 0) {
                if ((A & 1) != (B & 1)) {
                    ans++;
                }
                A = A >>> 1;
                B = B >>> 1;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            System.out.println(new Solution().convertInteger(A, B));
        }
    }
}
