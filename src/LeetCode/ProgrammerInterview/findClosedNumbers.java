package LeetCode.ProgrammerInterview;
/*
面试题 05.04. 下一个数
下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。

示例1:

 输入：num = 2（或者0b10）
 输出：[4, 1] 或者（[0b100, 0b1]）
示例2:

 输入：num = 1
 输出：[2, -1]
提示:

num的范围在[1, 2147483647]之间；
如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
通过次数1,270提交次数3,012
 */

import java.util.Scanner;

//自己不会写。。。
public class findClosedNumbers {
    static class Solution {
        public int[] findClosedNumbers(int num) {
            int[] ans = {-1, -1};
            int count = Integer.bitCount(num);
            if (num != Integer.MAX_VALUE) {
                for (int i = num + 1; i <= Integer.MAX_VALUE; i++) {
                    if (Integer.bitCount(i) == count) {
                        ans[0] = i;
                        break;
                    }
                }
            }
            for (int i = num - 1; i >= 1; i--) {
                if (Integer.bitCount(i) == count) {
                    ans[1] = i;
                    break;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] ans = new Solution().findClosedNumbers(scanner.nextInt());
            System.out.println();
            for (int x : ans) {
                System.out.print(x + " ");
            }
        }
    }
}
