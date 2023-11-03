package leetcode.tooffer;
/*
面试题10- II. 青蛙跳台阶问题
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：

输入：n = 2
输出：2
示例 2：

输入：n = 7
输出：21
提示：

0 <= n <= 100
注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/



通过次数3,988提交次数9,089
 */

import java.util.Scanner;

//力扣上题目给的测试用例有问题
public class numWays {
    static class Solution {
        public int numWays(int n) {
            int[] dp = new int[101];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            if (n == 0 || n == 1 || n == 2) return dp[n];
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
                if (dp[i] >= 1000000007) {
                    dp[i] -= 1000000007;
                }
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new fib.Solution().fib(scanner.nextInt()));
    }
}
