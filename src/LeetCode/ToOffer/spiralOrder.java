package LeetCode.ToOffer;
/*
面试题29. 顺时针打印矩阵
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。



示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]


限制：

0 <= matrix.length <= 100
0 <= matrix[i].length <= 100
注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/

通过次数2,579提交次数6,096
 */

import java.util.Scanner;

public class spiralOrder {
    static class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0) return new int[0];
            int[] ans = new int[matrix.length * matrix[0].length];
            int index = 0;
            int rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;
            while (index < ans.length) {
                for (int i = colBegin; colBegin <= colEnd && i <= colEnd && index < ans.length; i++) {
                    ans[index++] = matrix[rowBegin][i];
                }
                rowBegin++;
                for (int i = rowBegin; rowBegin <= rowEnd && i <= rowEnd && index < ans.length; i++) {
                    ans[index++] = matrix[i][colEnd];
                }
                colEnd--;
                for (int i = colEnd; colBegin <= colEnd && i >= colBegin && index < ans.length; i--) {
                    ans[index++] = matrix[rowEnd][i];
                }
                rowEnd--;
                for (int i = rowEnd; rowBegin <= rowEnd && i >= rowBegin && index < ans.length; i--) {
                    ans[index++] = matrix[i][colBegin];
                }
                colBegin++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] ans = new Solution().spiralOrder(matrix);
        for (int x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
