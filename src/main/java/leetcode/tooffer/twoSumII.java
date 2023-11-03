package leetcode.tooffer;
/*
面试题60. n个骰子的点数
把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。



你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。



示例 1:

输入: 1
输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
示例 2:

输入: 2
输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]


限制：

1 <= n <= 11

通过次数2,560提交次数4,719
 */

import java.util.Scanner;

//自己没想到。。
public class twoSumII {
    static class Solution {
        public double[] twoSum(int n) {
            int[][] dp = new int[n + 1][6 * n + 1];
            for (int i = 1; i <= 6; i++) {
                dp[1][i] = 1;
            }
            for (int i = 2; i <= n; i++) {
                for (int j = i; j <= 6 * i; j++) {
                    for (int k = 1; k <= 6; k++) {
                        if (j - k <= 0) break;
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
            double[] ans = new double[6 * n - n + 1];
            double sum = Math.pow(6, n);
            for (int i = 0; i < ans.length; i++) {
                ans[i] = dp[n][n + i] / sum;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double[] ans = new Solution().twoSum(scanner.nextInt());
            for (double x : ans) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }
}
