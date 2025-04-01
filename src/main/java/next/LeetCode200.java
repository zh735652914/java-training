package next;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/4/1 08:23
 * https://leetcode.cn/problems/number-of-islands/
 */
public class LeetCode200 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    find(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void find(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] != '1') {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '2';
        }
        for (int[] dir : dirs) {
            find(grid, x + dir[0], y + dir[1]);
        }
    }

    @Test
    public void test() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        assertEquals(1, numIslands(grid));
    }
}
