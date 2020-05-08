package LeetCode.ProgrammerInterview;
/*
面试题 01.08. Zero Matrix LCCI
Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.



Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
通过次数1,994提交次数3,167
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class setZeroes {
    static class Solution {
        public void setZeroes(int[][] matrix) {
            boolean firstRow = false;
            for (int i = 0; i < matrix.length; i++) {
                boolean delrow = false;
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        if (i == 0) {
                            firstRow = true;
                        } else {
                            delrow = true;
                        }
                        matrix[0][j] = 0;
                    }
                }
                if (delrow) {
                    matrix[i] = new int[matrix[i].length];
                }
            }
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    for (int j = 1; j < matrix.length; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
            if (firstRow) matrix[0] = new int[matrix[0].length];


            OUTPUT(matrix);
        }

        public void setZeroes0(int[][] matrix) {
            List<Integer> row = new ArrayList<>();
            List<Integer> col = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        if (!row.contains(i)) row.add(i);
                        if (!col.contains(j)) col.add(j);
                    }
                }
            }
            for (int x : row) {
                Arrays.fill(matrix[x], 0);
            }
            for (int y : col) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][y] = 0;
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
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        new Solution().setZeroes(matrix);
    }
}
