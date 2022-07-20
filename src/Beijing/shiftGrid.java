package Beijing;
/*
https://leetcode.cn/problems/shift-2d-grid/
 */

import java.util.ArrayList;
import java.util.List;

// 这道简单题写了很久
public class shiftGrid {
    static class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            /*
             index=x*row+y
             */
            int[] nums = new int[grid.length * grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    int index = i * grid[0].length + j;
                    nums[(index + k) % nums.length] = grid[i][j];
                }
            }
            List<List<Integer>> ans = new ArrayList<>();
            int index = 0;
            while (index < nums.length) {
                List<Integer> N = new ArrayList<>(grid[0].length);
                for (int i = 0; i < grid[0].length; i++) {
                    N.add(nums[index++]);
                }
                ans.add(N);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1}, {2}, {3}, {4}, {7}, {6}, {5}};
        int k = 23;
        System.out.println(new Solution().shiftGrid(grid, k));
    }
}
