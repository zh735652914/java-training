package leetcode;

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */
class NumberofIslandsSolution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !flag[i][j]) {
                    flag[i][j] = true;
                    DFS(grid, flag, i, j);
                    ans++;
                }
            }
        }
//        for (int i = 0; i < flag.length; i++) {
//            for (int j = 0; j < flag[i].length; j++) {
//                System.out.print(flag[i][j] + "  ");
//            }
//            System.out.println();
//        }
        return ans;
    }

    private void DFS(char[][] grid, boolean[][] flag, int x, int y) {
        if (y + 1 < grid[0].length && grid[x][y + 1] == '1' && !flag[x][y + 1]) {
            flag[x][y + 1] = true;
            DFS(grid, flag, x, y + 1);
        }
        if (y - 1 >= 0 && grid[x][y - 1] == '1' && !flag[x][y - 1]) {
            flag[x][y - 1] = true;
            DFS(grid, flag, x, y - 1);
        }
        if (x + 1 < grid.length && grid[x + 1][y] == '1' && !flag[x + 1][y]) {
            flag[x + 1][y] = true;
            DFS(grid, flag, x + 1, y);
        }
        if (x - 1 >= 0 && grid[x - 1][y] == '1' && !flag[x - 1][y]) {
            flag[x - 1][y] = true;
            DFS(grid, flag, x - 1, y);
        }
    }
}

public class NumberofIslands {
    public static void main(String[] args) {
        NumberofIslandsSolution numberofIslandsSolution = new NumberofIslandsSolution();
//        char[][] grid = {
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}
//        };
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        };
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        System.out.println(numberofIslandsSolution.numIslands(grid));
    }
}
