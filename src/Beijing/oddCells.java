package Beijing;
/*
https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/
 */

public class oddCells {
    // 看懂题目很重要
    static class Solution {
        public int oddCells(int m, int n, int[][] indices) {
            int[][] matrix = new int[m][n];
            for (int[] indice : indices) {
                for (int i = 0; i < n; i++) {
                    matrix[indice[0]][i]++;
                }
                for (int i = 0; i < m; i++) {
                    matrix[i][indice[1]]++;
                }
            }
            int count = 0;
            for (int[] R : matrix) {
                for (int num : R) {
                    if ((num & 1) == 1) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int m = 2, n = 3;
        int[][] indices = {{0, 1}, {1, 1}};
        System.out.println(new Solution().oddCells(m, n, indices));
    }
}
