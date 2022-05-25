package Beijing.hot100;
/*
https://leetcode.cn/problems/rotate-image/
 */

public class rotateImage_48 {
    // 自己没想出来，看了官方解析才知道是先水平翻转再对角翻转
    static class Solution {
        public void rotate(int[][] matrix) {
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[matrix.length - 1 - i][j];
                    matrix[matrix.length - 1 - i][j] = tmp;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix[i].length; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        new Solution().rotate(matrix);
        for (int[] rows : matrix) {
            for (int col : rows) {
                System.out.print(col + ", ");
            }
            System.out.println();
        }
    }
}
