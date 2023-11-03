package nowcoder;
/*
 牛客题霸-名企高频面试题
换钱的最少货币数
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：203
本题知识点： 动态规划
 算法知识视频讲解
题目描述
给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
如果无解，请返回-1.
【要求】
时间复杂度O(n \times aim)O(n×aim)，空间复杂度On。
示例1
输入
复制
[5,2,3],20
输出
复制
4
示例2
输入
复制
[5,2,3],0
输出
复制
0
示例3
输入
复制
[3,5],2
输出
复制
-1
备注:
0 \leq n \leq 1\,0000≤n≤1000
0 \leq aim \leq 5\,0000≤aim≤5000
 */

public class minMoney {
    static public class Solution {
        /**
         * 最少货币数
         *
         * @param arr int整型一维数组 the array
         * @param aim int整型 the target
         * @return int整型
         */

        public int minMoney(int[] arr, int aim) {
            int[][] dp = new int[arr.length][aim + 1];
            for (int i = 0; i <= aim; i++) {
                if (arr[0] < i && i % arr[0] == 0) {
                    dp[0][i] = i / arr[0];
                } else {
                    dp[0][i] = Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                dp[i][0] = 0;
            }
            for (int i = 1; i < arr.length; i++) {
                for (int j = 1; j <= aim; j++) {
                    if (j >= arr[i] && dp[i][j - arr[i]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - arr[i]] + 1);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[arr.length - 1][aim] == Integer.MAX_VALUE ? -1 : dp[arr.length - 1][aim];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3};
        int aim = 20;
        System.out.println(new Solution().minMoney(arr, aim));
    }
}
