package nowcoder;
/*
 牛客题霸-名企高频面试题
最大正方形
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：3154
本题知识点： 动态规划
 算法知识视频讲解
题目描述
给定一个由0和1组成的2维矩阵，返回该矩阵中最大的由1组成的正方形的面积
示例1
输入
复制
[[1,0,1,0,0],[1,0,1,1,1],[1,1,1,1,1],[1,0,0,1,0]]
输出
复制
4
题解 讨论 通过的代码笔记 纠错 收藏
 */

public class NC108 {
    static public class Solution {
        /**
         * 最大正方形
         *
         * @param matrix char字符型二维数组
         * @return int整型
         */
        public int solve(char[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            int[][] dp = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            }
            for (int i = 0; i < matrix[0].length; i++) {
                dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            }
            int maxLen = 0;
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i].length; j++) {
                    int last = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    dp[i][j] = matrix[i][j] == '1' ? last + 1 : 0;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
            return maxLen * maxLen;
        }
    }

    public static void main(String[] args) {
//        char[][] matrix = {
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}
//        };
        char[][] matrix = {
                {'1', '1', '1', '1'},
                {'0', '1', '0', '1'}
        };
        System.out.println(new Solution().solve(matrix));
    }
}
