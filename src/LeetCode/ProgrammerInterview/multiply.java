package LeetCode.ProgrammerInterview;
/*
面试题 08.05. 递归乘法
递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。

示例1:

 输入：A = 1, B = 10
 输出：10
示例2:

 输入：A = 3, B = 4
 输出：12
提示:

保证乘法范围不会溢出
通过次数5,239提交次数7,783
 */

import java.util.Scanner;

//自己没想到。。。
public class multiply {
    static class Solution {
        public int multiply(int A, int B) {
            return backtrack(Math.max(A, B), Math.min(A, B));
        }

        private int backtrack(int big, int small) {
            if (small == 1) return big;
            if (small == 2) return big + big;
            if (small % 2 == 0) {
                return backtrack(big, small / 2) << 1;
            } else {
                return big + (backtrack(big, small / 2) << 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().multiply(scanner.nextInt(), scanner.nextInt()));
        }
    }
}
