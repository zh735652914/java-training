package Beijing;
/*
https://leetcode-cn.com/problems/number-of-islands/
 */

import java.util.Arrays;

public class numIslands {
    static class Solution {
        private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int numIslands(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean dfs(char[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
                return false;
            }
            grid[x][y] = '2';
            for (int[] dir : directions) {
                dfs(grid, x + dir[0], y + dir[1]);
            }
            return true;
        }
    }

    static class Solution0 {
        private boolean[][] visited;
        private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int numIslands(char[][] grid) {
            visited = new boolean[grid.length][grid[0].length];
            for (boolean[] x : visited) {
                Arrays.fill(x, false);
            }
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean dfs(char[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y]) {
                return false;
            }
            visited[x][y] = true;
            if (grid[x][y] == '0') {
                return false;
            }
            for (int[] dir : directions) {
                dfs(grid, x + dir[0], y + dir[1]);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(new Solution().numIslands(grid));
    }
}
