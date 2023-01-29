package leetcode;
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

import java.util.ArrayList;
import java.util.List;

class SpiralMatrixSolution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return ans;
        backtrack(matrix, matrix.length, matrix[0].length);
        return ans;
    }

    private void backtrack(int[][] matrix, int m, int n) {
        if (m < 1 || n < 1) return;
        int x = (matrix.length - m) / 2;
        int y = (matrix[0].length - n) / 2;
        int a = y + 0, b = x + 0, c = y + n - 1, d = x + m - 1;
        if (m > 1 && n > 1) {
            for (int i = 0; i < 2 * (m + n - 2); i++) {
                if (i < n) {
//                    y += i;
//                    y++;
                    y = a + i;
                    ans.add(matrix[x][y]);
                }
                if (i >= n && i < (m + n - 1)) {
                    x = b + i - n + 1;
                    ans.add(matrix[x][y]);
                }
                if (i >= (m + n - 1) && i < (m + 2 * n - 2)) {
                    y = c - (i - (m + n - 1)) - 1;
                    ans.add(matrix[x][y]);
                }
                if (i >= (m + 2 * n - 2) && i < 2 * (m + n - 2)) {
                    x = d - (i - (m + 2 * n - 2)) - 1;
                    ans.add(matrix[x][y]);
                }
            }
        } else if (m == 1) {
            for (int i = 0; i < n; i++) {
                ans.add(matrix[x][y + i]);
            }
        } else {
            for (int i = 0; i < m; i++) {
                ans.add(matrix[x + i][y]);
            }
        }
        backtrack(matrix, m - 2, n - 2);
    }
}

public class SpiralMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        int[][] matrix = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
//        };
        int[][] matrix = {};
        SpiralMatrixSolution SMS = new SpiralMatrixSolution();
        System.out.println(SMS.spiralOrder(matrix));
    }
}
