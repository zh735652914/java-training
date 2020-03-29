package LeetCode.ProgrammerInterview;
/*
面试题 01.07. Rotate Matrix LCCI
Given an image represented by an N x N matrix, where each pixel in the image is 4 bytes,
write a method to rotate the image by 90 degrees. Can you do this in place?



Example 1:

Given matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

Rotate the matrix in place. It becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

Rotate the matrix in place. It becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
通过次数2,393提交次数3,167
 */

public class rotate {
    static class Solution {
        public void rotate(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length / 2; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix[i].length - j - 1];
                    matrix[i][matrix[i].length - j - 1] = tmp;
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length - i; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[matrix.length - 1 - j][matrix.length - 1 - i];
                    matrix[matrix.length - 1 - j][matrix.length - 1 - i] = tmp;
                }
            }


            OUTPUT(matrix);
        }

        private void OUTPUT(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + ",");
                }
                System.out.println();
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
    }
}
