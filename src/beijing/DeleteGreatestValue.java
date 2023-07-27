package beijing;
/*
https://leetcode.cn/problems/delete-greatest-value-in-each-row/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/7/27 13:38
 */
public class DeleteGreatestValue {
    // 这个方法很一般
    static class Solution {
        public int deleteGreatestValue(int[][] grid) {
            for (int[] row : grid) {
                Arrays.sort(row);
            }
            int ans = 0;
            for (int i = 0; i < grid[0].length; i++) {
                int max = 0;
                for (int j = 0; j < grid.length; j++) {
                    max = Math.max(max, grid[j][i]);
                }
                ans += max;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 4}, {3, 3, 1}};
        System.out.println(new Solution().deleteGreatestValue(grid));
    }
}
