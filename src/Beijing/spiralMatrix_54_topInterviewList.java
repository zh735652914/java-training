package Beijing;
/*
https://leetcode.cn/problems/spiral-matrix/
 */

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix_54_topInterviewList {
    // 怎么第三次写还写不利索了
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int top = 0, buttom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
            List<Integer> ans = new ArrayList<>();
            while (true) {
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;
                if (top > buttom) {
                    break;
                }
                for (int i = top; i <= buttom; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;
                if (left > right) {
                    break;
                }
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[buttom][i]);
                }
                buttom--;
                if (top > buttom) {
                    break;
                }
                for (int i = buttom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
                if (left > right) {
                    break;
                }
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
