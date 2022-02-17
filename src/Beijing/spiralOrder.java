package Beijing;
/*
https://leetcode-cn.com/problems/spiral-matrix/
 */

import java.util.LinkedList;
import java.util.List;

public class spiralOrder {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new LinkedList<>();
            int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
            int numsSie = matrix.length * matrix[0].length;
            while (numsSie > 0) {
                for (int i = left; i <= right && numsSie > 0; i++) {
                    ans.add(matrix[top][i]);
                    numsSie--;
                }
                top++;
                for (int i = top; i <= bottom && numsSie > 0; i++) {
                    ans.add(matrix[i][right]);
                    numsSie--;
                }
                right--;
                for (int i = right; i >= left && numsSie > 0; i--) {
                    ans.add(matrix[bottom][i]);
                    numsSie--;
                }
                bottom--;
                for (int i = bottom; i >= top && numsSie > 0; i--) {
                    ans.add(matrix[i][left]);
                    numsSie--;
                }
                left++;
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
        System.out.println(new Solution().spiralOrder(matrix));
    }
}
