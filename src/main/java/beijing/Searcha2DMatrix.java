package beijing;
/*
https://leetcode-cn.com/problems/search-a-2d-matrix/
 */

// 从右上角开始搜索就行
public class Searcha2DMatrix {
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int x = 0, y = matrix[0].length - 1;
            while (x < matrix.length && y >= 0) {
                if (target == matrix[x][y]) {
                    return true;
                } else if (target < matrix[x][y]) {
                    y--;
                } else {
                    x++;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
//        };
        int[][] matrix = {{1, 1}};
        int target = 3;
        System.out.println(new Solution().searchMatrix(matrix, target));
    }
}
