package LeetCode;
/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 */

class MaximalSquareSolution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') continue;
                max = Math.max(square(matrix, i, j), max);
            }
        }
        return max * max;
    }

    private int square(char[][] matrix, int x, int y) {
        int len = 1;
        while (isSquare(matrix, x, y, len)) {
            len++;
        }
        if (--len == 0) return 1;
        return len;
    }

    private boolean isSquare(char[][] matrix, int x, int y, int len) {
        if (x + len > matrix.length || y + len > matrix[x].length) return false;
        for (int i = x; i < (x + len) && i < matrix.length; i++) {
            for (int j = y; j < (y + len) && j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') return false;
            }
        }
        return true;
    }
}

public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
//        char[][] matrix = {{'1'}};
        MaximalSquareSolution maximalSquareSolution = new MaximalSquareSolution();
        System.out.println(maximalSquareSolution.maximalSquare(matrix));
    }
}
