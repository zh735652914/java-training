package leetcode.tooffer;
/*
面试题15. 二进制中1的个数
请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

示例 1：

输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
示例 2：

输入：00000000000000000000000010000000
输出：1
解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
示例 3：

输入：11111111111111111111111111111101
输出：31
解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。


注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/

通过次数4,361提交次数5,918
 */

import java.util.Scanner;

//有符号位！！！
public class hammingWeight {
    static public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int ans = 0;
            while (n != 0) {
                ans += n & 1;
                // >>为有符号右移， >>>为无符号右移
                n = n >>> 1;
            }
            return ans;
        }

        public int hammingWeight2(int n) {
            return Integer.bitCount(n);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().hammingWeight(scanner.nextInt()));
        }
//        System.out.println(new Solution().hammingWeight(Integer.MAX_VALUE));
    }
}
