package Beijing;
/*
https://leetcode.cn/problems/number-of-islands/
 */

public class NumberofIslands_200_topInterviewList {
    // 纯dfs
    static class Solution {

        private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int numIslands(char[][] grid) {
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        ans++;
                    }
                }
            }
            return ans;
        }

        private void dfs(char[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return;
            }
            if (grid[x][y] == '0' || grid[x][y] == '2') {
                return;
            }
            if (grid[x][y] == '1') {
                grid[x][y] = '2';
            }
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
