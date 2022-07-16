package Beijing;
/*
https://leetcode.cn/problems/spiral-matrix/
 */

import java.util.ArrayList;
import java.util.List;

// 标好上下左右就行
public class spiralMatrix_54 {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
            while (true) {
                if (left > right) {
                    break;
                }
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;
                if (top > bottom) {
                    break;
                }
                for (int i = top; i <= bottom; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;
                if (left > right) {
                    break;
                }
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
                if (top > bottom) {
                    break;
                }
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
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
