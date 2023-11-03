package beijing;
/*
https://leetcode.cn/problems/largest-1-bordered-square/
 */

/**
 * @author zhouhao
 * @date 2023/2/17 14:43
 */
public class Largest1BorderedSquare {
    // 挺有意思的一题
    static class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int[][] left = new int[grid.length + 1][grid[0].length + 1];
            int[][] up = new int[grid.length + 1][grid[0].length + 1];
            int ans = 0;
            for (int i = 1; i <= grid.length; i++) {
                for (int j = 1; j <= grid[0].length; j++) {
                    if (grid[i - 1][j - 1] == 0) {
                        continue;
                    }
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;
                    int boarder = Math.min(left[i][j], up[i][j]);
                    while (left[i - boarder + 1][j] < boarder || up[i][j - boarder + 1] < boarder) {
                        boarder--;
                    }
                    ans = Math.max(ans, boarder);
                }
            }
            return ans * ans;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        System.out.println(new Solution().largest1BorderedSquare(grid));
    }
}
