package LeetCode;
/*
logo
探索
题库
圈子
竞赛
企业
商店


题目描述
评论 (2.8k)
题解(2880)
提交记录
7. 整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

通过次数489,308提交次数1,409,859
 */

import java.util.Scanner;

public class reverse {
    static class Solution {
        public int reverse(int x) {
            int sign = 1;
            if (x < 0) {
                if (x == Integer.MIN_VALUE) {
                    return 0;
                }
                sign = -sign;
                x = -x;
            }
            int ans = 0;
            while (x > 0) {
                int cur = x % 10;
                if (ans > (Integer.MAX_VALUE - cur) / 10) {
                    return 0;
                }
                ans *= 10;
                ans += cur;
                x /= 10;
            }
            return ans * sign;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().reverse(scanner.nextInt()));
        }
    }
}
