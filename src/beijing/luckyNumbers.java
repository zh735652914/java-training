package beijing;
/*
https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
 */

import java.util.ArrayList;
import java.util.List;

public class luckyNumbers {
    static class Solution {
        public List<Integer> luckyNumbers(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                int minRow = matrix[i][0];
                int y = 0;
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] < minRow) {
                        minRow = matrix[i][j];
                        y = j;
                    }
                }
                boolean flag = true;
                for (int j = 0; j < matrix.length; j++) {
                    if (minRow <= matrix[j][y] && j != i) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans.add(minRow);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17}
        };
        System.out.println(new Solution().luckyNumbers(matrix));
    }
}
