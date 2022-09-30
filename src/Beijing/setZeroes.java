package Beijing;
/*
https://leetcode.cn/problems/zero-matrix-lcci/
 */

import java.util.Arrays;

public class setZeroes {
    // 写的不是太顺手
    static class Solution {
        public void setZeroes(int[][] matrix) {
            boolean firstRowZ = false, firstColZ = false;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    firstColZ = true;
                    break;
                }
            }
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    firstRowZ = true;
                    break;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    Arrays.fill(matrix[i], 0);
                }
            }
            for (int i = 1; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    for (int j = 1; j < matrix.length; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
            if (firstRowZ) {
                Arrays.fill(matrix[0], 0);
            }
            if (firstColZ) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
//        int[][] matrix = {{0}, {1}};
        new Solution().setZeroes(matrix);
        for (int[] row : matrix) {
            for (int x : row) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }
}
