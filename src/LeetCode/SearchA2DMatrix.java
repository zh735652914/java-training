package LeetCode;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 */
class SearchA2DMatrixSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1) return false;
        return Search(matrix, target, 0, 0);
    }

    private boolean Search(int[][] matrix, int target, int x, int y) {
        if (x >= matrix.length || y >= matrix[0].length) return false;
        if (target < matrix[x][y]) return false;
        if (target == matrix[x][y]) return true;
        int R = Integer.MAX_VALUE;
        int D = Integer.MAX_VALUE;
        if (y + 1 < matrix[0].length) {
            int right = matrix[x][y + 1];
            if (right <= target) {
                R = target - right;
            }
            if (R == 0) return true;
        }
        if (x + 1 < matrix.length) {
            int down = matrix[x + 1][y];
            if (down <= target) {
                D = target - down;
            }
            if (D == 0) return true;
        }
        if (R < D) {
            return Search(matrix, target, x, y + 1);
        } else {
            if (x + 1 < matrix.length) {
                return Search(matrix, target, x + 1, y);
            } else {
                return Search(matrix, target, x, y + 1);
            }
        }
    }
}

public class SearchA2DMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}
//        };
        int[][] matrix = {
                {1, 3, 6, 7},
                {4, 11, 16, 20},
                {5, 30, 34, 50}
        };
//        int[][] matrix = {{1}, {2}, {5}};
        int target = 5;
        SearchA2DMatrixSolution SAM = new SearchA2DMatrixSolution();
        if (SAM.searchMatrix(matrix, target)) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }
}
