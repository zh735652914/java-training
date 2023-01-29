package leetcode;

/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
class RotateImageSolution {
    public void rotate(int[][] matrix) {
//        int[][] ans = backtrack(matrix, matrix.length);
//        System.out.println(ans);
        backtrack(matrix, matrix[0].length);
    }

    private void backtrack(int[][] matrix, int n) {
        if (n < 2) return;
        int[] T1 = new int[n];
        int[] T2 = new int[n];
        int[] T3 = new int[n];
        int[] T4 = new int[n];
        int x = (matrix.length - n) / 2;
        for (int i = 0; i < n; i++) {
            T1[i] = matrix[x][x + i];
            T2[i] = matrix[x + i][matrix.length - x - 1];
            T3[i] = matrix[matrix.length - x - 1][matrix.length - x - 1 - i];
            T4[i] = matrix[matrix.length - x - 1 - i][x];
        }
        for (int i = 0; i < n; i++) {
            matrix[x][x + i] = T4[i];
            matrix[x + i][matrix.length - x - 1] = T1[i];
            matrix[matrix.length - x - 1][matrix.length - x - 1 - i] = T2[i];
            matrix[matrix.length - x - 1 - i][x] = T3[i];
        }
        backtrack(matrix, n - 2);
    }
}

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
//        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        RotateImageSolution RIS = new RotateImageSolution();
        RIS.rotate(matrix);
    }
}
