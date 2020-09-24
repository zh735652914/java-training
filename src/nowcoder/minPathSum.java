package nowcoder;
/*
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：1985
本题知识点： 数组 动态规划
 算法知识视频讲解
题目描述
给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
示例1
输入
复制
[[1,3,5,9],[8,1,3,4],[5,0,6,1],[8,8,4,0]]
输出
复制
12
备注:
1 \leq n,m \leq 20001≤n,m≤2000
1 \leq arr_{i,j} \leq 1001≤arr
i,j
​
 ≤100
 */

public class minPathSum {
    static public class Solution0 {
        /**
         * @param matrix int整型二维数组 the matrix
         * @return int整型
         */
        private int minPath;

        public int minPathSum(int[][] matrix) {
            minPath = Integer.MAX_VALUE;
            dfs(matrix, 0, 0, 0);
            return minPath;
        }

        private void dfs(int[][] matrix, int x, int y, int sum) {
            if (x >= matrix.length || y >= matrix[0].length) {
                return;
            }
            sum += matrix[x][y];
            if (x == matrix.length - 1 && y == matrix[0].length - 1) {
                minPath = Math.min(minPath, sum);
            }
            dfs(matrix, x + 1, y, sum);
            dfs(matrix, x, y + 1, sum);
        }
    }

    static public class Solution {
        /**
         * @param matrix int整型二维数组 the matrix
         * @return int整型
         */
        public int minPathSum(int[][] matrix) {
            int[][] dp = new int[matrix.length][matrix[0].length];
            dp[0][0] = matrix[0][0];
            for (int i = 1; i < matrix.length; i++) {
                dp[i][0] = dp[i - 1][0] + matrix[i][0];
            }
            for (int i = 1; i < matrix[0].length; i++) {
                dp[0][i] = dp[0][i - 1] + matrix[0][i];
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i].length; j++) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            return dp[matrix.length - 1][matrix[0].length - 1];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}
        };
        System.out.println(new Solution().minPathSum(matrix));
    }
}
