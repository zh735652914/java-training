package beijing;
/*
https://leetcode.cn/problems/check-knight-tour-configuration/?envType=daily-question&envId=2023-09-13
 */

/**
 * @author zhouhao
 * @date 2023/9/13 13:45
 */
public class CheckValidGrid {
    // 很重要的dfs
    static class Solution {
        private final int[][] dirs = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};

        public boolean checkValidGrid(int[][] grid) {
            return dfs(grid, 0, 0, 0);
        }

        private boolean dfs(int[][] grid, int x, int y, int count) {
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || count != grid[x][y]) {
                return false;
            }
            if (count == grid.length * grid[0].length - 1) {
                return true;
            }
            count++;
            for (int[] dir : dirs) {
                if (dfs(grid, x + dir[0], y + dir[1], count)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 11, 16, 5, 20},
                {17, 4, 19, 10, 15},
                {12, 1, 8, 21, 6},
                {3, 18, 23, 14, 9},
                {24, 13, 2, 7, 22}
        };
        System.out.println(new Solution().checkValidGrid(grid));
    }
}
