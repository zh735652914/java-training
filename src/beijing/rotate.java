package beijing;
/*
https://leetcode-cn.com/problems/rotate-image/
 */

/*
情况一：顺时针转 90 度：先转置再左右镜像
1 2 3               7 4 1
4 5 6               8 5 2
7 8 9               9 6 3
情况二：顺时针转 180 度:先上下镜像，再左右镜像（先左右再上下也可）
1 2 3               9 8 7
4 5 6               6 5 4
7 8 9               3 2 1
情况三：顺时针转 270 度：先转置再上下镜像
1 2 3              3 6 9
4 5 6              2 5 8
7 8 9              1 4 7
 */
public class rotate {
    static class Solution {
        public void rotate(int[][] matrix) {
            for (int i = 0; i < matrix.length / 2; i++) {
                int[] tmp = matrix[matrix.length - i - 1];
                matrix[matrix.length - i - 1] = matrix[i];
                matrix[i] = tmp;
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i; j < matrix[i].length; j++) {
                    swap(matrix, i, j, j, i);
                }
            }
        }

        private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
            int tmp = matrix[x2][y2];
            matrix[x2][y2] = matrix[x1][y1];
            matrix[x1][y1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new Solution().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
