package Beijing.hot100;
/*
https://leetcode.cn/problems/number-of-islands/
 */

public class numberofIslands_200 {
    // 很典型的dfs
    static class Solution {
        private final int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        private boolean[][] visited;

        public int numIslands(char[][] grid) {
            visited = new boolean[grid.length][grid[0].length];
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (!visited[i][j] && grid[i][j] == '1') {
                        count++;
                        dfs(grid, i, j);
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == '0') {
                return;
            }
            visited[x][y] = true;
            for (int[] dir : dirs) {
                dfs(grid, x + dir[0], y + dir[1]);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new Solution().numIslands(grid));
    }
}
