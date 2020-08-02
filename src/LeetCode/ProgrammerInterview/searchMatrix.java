package LeetCode.ProgrammerInterview;
/*
面试题 10.09. 排序矩阵查找
给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。

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

通过次数4,150提交次数9,101
 */

import java.util.Scanner;

//这题写过
public class searchMatrix {
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
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
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().searchMatrix(matrix, scanner.nextInt()));
        }
    }
}
