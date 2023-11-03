package leetcode;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 */
//看了Discuss，感觉自己是个智障。。。
class Searcha2DMatrixIISolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
        int x = 0, y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (target == matrix[x][y]) return true;
            if (target > matrix[x][y]) {
                x++;
                continue;
            }
            if (target < matrix[x][y]) y--;
        }
        return false;
    }

}

public class Searcha2DMatrixII {
    public static void main(String[] args) {
        int target = 5;
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Searcha2DMatrixIISolution searcha2DMatrixIISolution = new Searcha2DMatrixIISolution();
        System.out.println(searcha2DMatrixIISolution.searchMatrix(matrix, target));
    }
}
