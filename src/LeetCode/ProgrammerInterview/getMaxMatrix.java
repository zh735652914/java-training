package LeetCode.ProgrammerInterview;
/*
面试题 17.24. 最大子矩阵
给定一个正整数和负整数组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。

返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。
若有多个满足条件的子矩阵，返回任意一个均可。

注意：本题相对书上原题稍作改动

示例:

输入:
[
   [-1,0],
   [0,-1]
]
输出: [0,1,0,1]
解释: 输入中标粗的元素即为输出所表示的矩阵
说明：

1 <= matrix.length, matrix[0].length <= 200
通过次数2,074提交次数4,021
 */

public class getMaxMatrix {
    static class Solution {
        public int[] getMaxMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int c1 = 0, c2 = 0;
            int maxSum = Integer.MIN_VALUE;
            int sum;
            int[] ans = new int[4];
            for (int r1 = 0; r1 < m; r1++) {
                int[] dp = new int[n];
                for (int r2 = r1; r2 < m; r2++) {
                    sum = 0;
                    for (int c = 0; c < n; c++) {
                        dp[c] += matrix[r2][c];
                        if (sum <= 0) {
                            sum = dp[c];
                            c1 = c;
                        } else {
                            sum += dp[c];
                        }
                        c2 = c;
                        if (sum > maxSum) {
                            maxSum = sum;
                            ans[0] = r1;
                            ans[1] = c1;
                            ans[2] = r2;
                            ans[3] = c2;
                        }
                    }

                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{-1, 0}, {0, -1}};
        int[][] matrix = {{9, -8, 1, 3, -2}, {-3, 7, 6, -2, 4}, {6, -4, -4, 8, -7}};
        int[] ans = new Solution().getMaxMatrix(matrix);
        for (int x : ans) {
            System.out.print(x + ",");
        }
        System.out.println();
    }
}
