package beijing;
/*
https://leetcode.cn/problems/diagonal-traverse/
 */

public class findDiagonalOrder {
    // 找规律模拟，不是自己写的
    static class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            if (mat == null || mat.length == 0) {
                return new int[]{};
            }
            int r = 0, c = 0;
            int row = mat.length, col = mat[0].length;
            int[] ans = new int[row * col];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = mat[r][c];
                if (((r + c) & 1) == 0) {
                    if (c == col - 1) {
                        r++;
                    } else if (r == 0) {
                        c++;
                    } else {
                        r--;
                        c++;
                    }
                } else {
                    if (r == row - 1) {
                        c++;
                    } else if (c == 0) {
                        r++;
                    } else {
                        r++;
                        c--;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] ans = new Solution().findDiagonalOrder(mat);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
