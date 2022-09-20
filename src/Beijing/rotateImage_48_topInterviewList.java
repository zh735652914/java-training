package Beijing;
/*
https://leetcode.cn/problems/rotate-image/
 */

public class rotateImage_48_topInterviewList {
    // 自己还是没想到怎么做
    static class Solution {
        public void rotate(int[][] matrix) {
            // 先水平翻转，再对角翻转
            int[] tmp;
            for (int i = 0; i < matrix.length / 2; i++) {
                tmp = matrix[matrix.length - 1 - i];
                matrix[matrix.length - 1 - i] = matrix[i];
                matrix[i] = tmp;
            }
            int xTmp;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix[i].length; j++) {
                    xTmp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = xTmp;
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
