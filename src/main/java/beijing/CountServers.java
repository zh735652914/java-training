package beijing;
/*
https://leetcode.cn/problems/count-servers-that-communicate/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/8/24 13:47
 */
public class CountServers {
    // 不像中等难度的题
    static class Solution {
        public int countServers(int[][] grid) {
            int[] row = new int[grid.length];
            int[] col = new int[grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                row[i] = Arrays.stream(grid[i]).sum();
            }
            for (int i = 0; i < grid[0].length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    col[i] += grid[j][i];
                }
            }
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 0) {
                        continue;
                    }
                    if (row[i] > 1 || col[j] > 1) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0},
                {1, 1}
        };
        System.out.println(new Solution().countServers(grid));
    }
}
