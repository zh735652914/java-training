package Beijing;
/*
https://leetcode-cn.com/problems/map-of-highest-peak/
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class highestPeak {
    static class Solution {
        private final int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        public int[][] highestPeak(int[][] isWater) {
            if (isWater == null) {
                return null;
            }
            int[][] height = new int[isWater.length][isWater[0].length];
            for (int i = 0; i < height.length; i++) {
                Arrays.fill(height[i], -1);
            }
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < isWater.length; i++) {
                for (int j = 0; j < isWater[i].length; j++) {
                    if (isWater[i][j] == 1) {
                        height[i][j] = 0;
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x >= 0 && x < isWater.length && y >= 0 && y < isWater[0].length && height[x][y] == -1) {
                        height[x][y] = height[pos[0]][pos[1]] + 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            return height;
        }
    }

    private static void test(int[][] matrix) {
        matrix[0][0] = 10;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println("!!!!!!!!");
    }

    public static void main(String[] args) {
        int[][] isWater = {
                {0, 0, 1},
                {1, 0, 0},
                {0, 0, 0}
        };
        int[][] height = new Solution().highestPeak(isWater);
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height[i].length; j++) {
                System.out.print(height[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println("~~~~~~~~~~~");
        int[][] matrix = {
                {0, 0, 1},
                {1, 0, 0},
                {0, 0, 0}
        };
        test(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
