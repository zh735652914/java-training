package LeetCode.ToOffer;
/*
面试题04. 二维数组中的查找
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。



示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。



限制：

0 <= n <= 1000

0 <= m <= 1000



注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/

通过次数5,853提交次数14,105
 */

//这题自己傻逼了。。。
public class findNumberIn2DArray {
    static class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) return false;
            return backtrack(matrix, target, 0, matrix[0].length - 1);
        }

        private boolean backtrack(int[][] matrix, int target, int x, int y) {
            if (x >= matrix.length || y < 0) return false;
            if (matrix[x][y] == target) return true;
            if (target > matrix[x][y]) {
                return backtrack(matrix, target, x + 1, y);
            } else {
                return backtrack(matrix, target, x, y - 1);
            }
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };
//        int target = 5;
        int[][] matrix = {{}};
        int target = 0;
//        int[][] matrix = {
//                {1, 2, 3, 4, 5},
//                {6, 7, 8, 9, 10},
//                {11, 12, 13, 14, 15},
//                {16, 17, 18, 19, 20},
//                {21, 22, 23, 24, 25}
//        };
//        int target = 19;
        System.out.println(new Solution().findNumberIn2DArray(matrix, target));
    }
}
