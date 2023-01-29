package beijing;
/*
https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 */

import java.util.ArrayList;
import java.util.List;

// 这个需要看看！！！！
public class pacificAtlantic {
    static class Solution {
        private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        private List<List<Integer>> ans;
        private int[][] heights;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            this.heights = heights;
            ans = new ArrayList<>();
            boolean[][] pacific = new boolean[m][n];
            boolean[][] atlantic = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                dfs(pacific, i, 0);
                dfs(atlantic, i, n - 1);
            }
            for (int i = 0; i < n; i++) {
                dfs(pacific, 0, i);
                dfs(atlantic, m - 1, i);
            }
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (pacific[x][y] && atlantic[x][y]) {
                        List<Integer> point = new ArrayList<>();
                        point.add(x);
                        point.add(y);
                        ans.add(point);
                    }
                }
            }
            return ans;
        }

        private void dfs(boolean[][] ocean, int x, int y) {
            if (ocean[x][y]) {
                return;
            }
            ocean[x][y] = true;
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newY >= 0 && newX < ocean.length && newY < ocean[0].length && heights[x][y] <= heights[newX][newY]) {
                    dfs(ocean, newX, newY);
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[][] heights = {
//                {1, 2, 2, 3, 5},
//                {3, 2, 3, 4, 4},
//                {2, 4, 5, 3, 1},
//                {6, 7, 1, 4, 5},
//                {5, 1, 1, 2, 4}
//        };
        int[][] heights = {
                {10, 10, 10},
                {10, 1, 10},
                {10, 10, 10}
        };
        // [[0,0],[0,1],[0,2],[1,0],[1,2],[2,0],[2,1],[2,2]]
        // [[0, 0], [0, 1], [0, 2], [1, 0], [1, 2], [2, 0], [2, 1], [2, 2]]
        System.out.println(new Solution().pacificAtlantic(heights));
    }
}
