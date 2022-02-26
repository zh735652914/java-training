package Beijing;
/*
https://leetcode-cn.com/problems/set-matrix-zeroes/
 */

public class SetMatrixZeroes {
    // 为什么自己想不到啊！！！！！！！
    static class Solution {
        public void setZeroes(int[][] matrix) {
            boolean row0 = false, col0 = false;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    col0 = true;
                }
            }
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    row0 = true;
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (col0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
            if (row0) {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[0][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        new Solution().setZeroes(matrix);
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + ", ");
            }
            System.out.println();
        }
    }
}
