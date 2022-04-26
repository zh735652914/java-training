package Beijing;
/*
https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
 */

// 简单题，细心就行
public class projectionArea {
    static class Solution {
        public int projectionArea(int[][] grid) {
            int buttom = 0, leftY = 0, rightX = 0;
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 0) {
                        buttom++;
                    }
                }
            }
            for (int[] gx : grid) {
                int max = 0;
                for (int x : gx) {
                    max = Math.max(x, max);
                }
                rightX += max;
            }
            for (int i = 0; i < n; i++) {
                int max = 0;
                for (int j = 0; j < m; j++) {
                    max = Math.max(max, grid[j][i]);
                }
                leftY += max;
            }
            return buttom + leftY + rightX;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2},
                {3, 4}
        };
        System.out.println(new Solution().projectionArea(grid));
    }
}
