package beijing;
/*
https://leetcode.cn/problems/number-of-closed-islands/
 */

/**
 * @author zhouhao
 * @date 2023/6/18 11:58
 */
public class ClosedIsland {
    // 写法最后的boolean很奇怪
    static class Solution {
        private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int closedIsland(int[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 0 && dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean dfs(int[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return false;
            }
            if (grid[x][y] == 1 || grid[x][y] == 2) {
                return true;
            }
            grid[x][y] = 2;
            // 这样写会出现问题
//            boolean isMatch = true;
//            for (int[] dir : dirs) {
//                isMatch = isMatch && dfs(grid, x + dir[0], y + dir[1]);
//            }
            boolean res1 = dfs(grid, x + dirs[0][0], y + dirs[0][1]);
            boolean res2 = dfs(grid, x + dirs[1][0], y + dirs[1][1]);
            boolean res3 = dfs(grid, x + dirs[2][0], y + dirs[2][1]);
            boolean res4 = dfs(grid, x + dirs[3][0], y + dirs[3][1]);
            return res1 && res2 && res3 && res4;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        System.out.println(new Solution().closedIsland(grid));
    }
}
