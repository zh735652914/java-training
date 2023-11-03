package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

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
 */
class SetMatrixZeroesSolution {
    public void setZeroes(int[][] matrix) {
//        int[] row = new int[matrix.length];
//        int[] col = new int[matrix[0].length];
//        int rowl = 0, coll = 0;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
//            if (!row.contains(i)) row.add(i);
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (!row.contains(i)) row.add(i);
                    if (!col.contains(j)) col.add(j);
                }
            }
        }
        for (int i = 0; i < row.size(); i++) {
            int R = row.get(i);
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[R][j] = 0;
            }
        }
        for (int i = 0; i < col.size(); i++) {
            int C = col.get(i);
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][C] = 0;
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        SetMatrixZeroesSolution SMZ = new SetMatrixZeroesSolution();
        SMZ.setZeroes(matrix);
    }
}
