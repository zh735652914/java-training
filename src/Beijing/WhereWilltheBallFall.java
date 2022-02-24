package Beijing;
/*
https://leetcode-cn.com/problems/where-will-the-ball-fall/
 */

public class WhereWilltheBallFall {
    // 自己不会写，没想明白
    static class Solution {
        public int[] findBall(int[][] grid) {
            // 1是向右，-1是向左；
            int[] ans = new int[grid[0].length];
            for (int i = 0; i < grid[0].length; i++) {
                int col = i;
                for (int[] row : grid) {
                    int dir = row[col];
                    col += dir;
                    if (col < 0 || col > grid[0].length - 1 || dir != row[col]) {
                        col = -1;
                        break;
                    }
                }
                ans[i] = col;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
//        int[][] grid = {
//                {1, 1, 1, -1, -1},
//                {1, 1, 1, -1, -1},
//                {-1, -1, -1, 1, 1},
//                {1, 1, 1, 1, -1},
//                {-1, -1, -1, -1, -1}
//        };
        int[][] grid = {
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1},
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1}
        };
        int[] ans = new Solution().findBall(grid);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}
