package beijing;
/*
https://leetcode.cn/problems/shortest-bridge/
 */

import java.util.LinkedList;
import java.util.Queue;

// 自己没写出来，这个dfs+bfs很有意思
public class shortestBridge {
    static class Solution {

        private final int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        public int shortestBridge(int[][] grid) {
            Queue<int[]> nodes = new LinkedList<>();
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[x].length; y++) {
                    if (grid[x][y] == 1) {
                        dfs(grid, x, y, nodes);
                    }
                    int count = 0;
                    while (!nodes.isEmpty()) {
                        int num = nodes.size();
                        for (int i = 0; i < num; i++) {
                            int[] node = nodes.poll();
                            for (int[] dir : dirs) {
                                int nX = node[0] + dir[0];
                                int nY = node[1] + dir[1];
                                if (nX >= 0 && nX < grid.length && nY >= 0 && nY < grid[0].length) {
                                    if (grid[nX][nY] == 0) {
                                        grid[nX][nY] = 2;
                                        nodes.offer(new int[]{nX, nY});
                                    } else if (grid[nX][nY] == 1) {
                                        return count;
                                    }
                                }
                            }
                        }
                        count++;
                    }
                }
            }
            return 0;
        }

        private void dfs(int[][] grid, int x, int y, Queue<int[]> nodes) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
                return;
            }
            grid[x][y] = 2;
            nodes.offer(new int[]{x, y});
            for (int[] dir : dirs) {
                dfs(grid, x + dir[0], y + dir[1], nodes);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        System.out.println(new Solution().shortestBridge(grid));
    }
}
