package beijing;
/*
https://leetcode.cn/problems/largest-local-values-in-a-matrix/
 */

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhouhao
 * @date 2023/3/1 12:54
 */
public class LargestLocal {
    // 可以用解析中的暴力
    static class Solution {
        public int[][] largestLocal(int[][] grid) {
            int[][] tmp = new int[grid.length][grid.length - 2];
            Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < 2; j++) {
                    queue.offer(grid[i][j]);
                }
                for (int j = 2; j < grid[i].length; j++) {
                    queue.offer(grid[i][j]);
                    tmp[i][j - 2] = queue.peek();
                    queue.remove(grid[i][j - 2]);
                }
                queue.clear();
            }
            int[][] ans = new int[grid.length - 2][grid[0].length - 2];
            for (int i = 0; i < tmp[0].length; i++) {
                for (int j = 0; j < 2; j++) {
                    queue.offer(tmp[j][i]);
                }
                for (int j = 2; j < tmp.length; j++) {
                    queue.offer(tmp[j][i]);
                    ans[j - 2][i] = queue.peek();
                    queue.remove(tmp[j - 2][i]);
                }
                queue.clear();
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {9, 9, 8, 1},
                {5, 6, 2, 6},
                {8, 2, 6, 4},
                {6, 2, 2, 2}
        };
        int[][] ans = new Solution().largestLocal(grid);
        for (int[] row : ans) {
            for (int col : row) {
                System.out.print(col + ", ");
            }
            System.out.println();
        }
    }
}
