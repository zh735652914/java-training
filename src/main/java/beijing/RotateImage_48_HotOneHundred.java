package beijing;
/*
https://leetcode.cn/problems/rotate-image/
 */

/**
 * @author zhouhao
 * @date 2023/5/24 12:58
 */
// 一定要记住规律！
public class RotateImage_48_HotOneHundred {
    static class Solution {
        public void rotate(int[][] matrix) {
            // 先水平翻转，再对角翻转
            int tmp = 0;
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    tmp = matrix[i][j];
                    matrix[i][j] = matrix[matrix.length - 1 - i][j];
                    matrix[matrix.length - 1 - i][j] = tmp;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix[i].length; j++) {
                    tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new Solution().rotate(matrix);
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + ", ");
            }
            System.out.println();
        }
    }
}
